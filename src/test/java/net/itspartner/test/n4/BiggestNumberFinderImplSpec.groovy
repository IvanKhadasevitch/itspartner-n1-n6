package net.itspartner.test.n4

import spock.lang.Specification

class BiggestNumberFinderImplSpec extends Specification{
    def "it should find the biggest number from array"() {
        given:
        def finder  = new BiggestNumberFinderImpl()
        when:
        def result = finder.findTheBiggestNumber([-3, 2, 115, 13, 0, -115] as int[]);
        then:
        result.equals(115)
    }

    def "it should return 0 for empty array"() {
        given:
        def finder  = new BiggestNumberFinderImpl()
        when:
        def result = finder.findTheBiggestNumber([] as int[]);
        then:
        result.equals(0)
    }

    def "it should return 0 for null array"() {
        given:
        def finder  = new BiggestNumberFinderImpl()
        when:
        def result = finder.findTheBiggestNumber(null);
        then:
        result.equals(0)
    }
}
