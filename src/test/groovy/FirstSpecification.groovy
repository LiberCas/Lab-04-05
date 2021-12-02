import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import spock.lang.Specification

class FirstSpecification extends Specification{
    def "two plus two should equal four"() {
        given:
        int left = 2
        int right = 2
        when:
        def result = left + right
        then:
        result == 4
    }
    def "Should be able to remove from list"() {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(0)
        then:
        list == [2, 3, 4]
    }
    def "Should get an index out of bounds when removing a nonexistent item"() {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(20)
        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }
    //Data Driven Testing
    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c
        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }
    def "distinct_bug_null"() {
        def deduplicator = Mock(GenericListDeduplicator)
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
        result == null
        //Because the method "deduplicate" hasn't yet been defined for the stub class, instead of throwing an exception
        //when it's calle(what is usually done), Spock return a sensible value(lenient mocking)
    }
    def "distinct_bug_8726"() {
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]
        def aggregator = new ListAggregator()
        when:
        def distinct1 = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator)
        def distinct2 = aggregator.distinct(Arrays.asList(6, 6, 6, 7, 6, 7, 7), deduplicator)
        then:
        distinct1 == 3
        distinct2 == 2
    }
}