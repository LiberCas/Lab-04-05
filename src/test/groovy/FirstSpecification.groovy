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
}
