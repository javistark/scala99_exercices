import org.scalatest.{FunSpec, Matchers}
import Chapter3.MyList
import Chapter3.MyList.{product, sum, tail, setHead, drop, dropWhile}
import Chapter3.{EmptyMyListException, InvalidArgumentException}

class Chapter3Spec extends FunSpec with Matchers {
  describe("MyList") {
    describe("sum") {
      it("should return 0 for an empty List") {
        sum(MyList()) should be(0)
      }

      it("should return x if the List only contains x") {
        sum(MyList(1000000)) should be(1000000)
      }

      it("should sum elements of a List") {
        sum(MyList(1, 2, 3)) should be(6)
      }

    }

    describe("product") {
      it("should return 1 for an empty list") {
        product(MyList()) should be(1)
      }

      it("should return 0 if there is at least a 0 in the list") {
        product(MyList(1, 100, 20000, 0, 5, -999)) should be(0)
      }

      it("should return the product of the elements of the list") {
        product(MyList(4, 5, 10)) should be(200)
      }
    }

    describe("tail") {
      it("tail(MyList(1,4,5,6)) should return 1") {
        tail(MyList(1,4,5,6)) should be(MyList(4,5,6))
      }

      it("tail(MyList(200)) should return 200") {
        tail(MyList(200)) should be(MyList())
      }

      it("tail(MyList()) should throw an Exception") {
        intercept[EmptyMyListException] {tail(MyList())}
      }
    }

    describe("setHead") {
      it("setHead('a' ,MyList('v', 'q', 'z')) should replace v by a") {
        setHead("a", MyList("v", "q", "z")) should be(MyList("a", "q", "z"))
      }

      it("setHead('2', MyList()) should raise an Exception") {
        intercept[EmptyMyListException] {setHead(2, MyList())}
      }
    }

    describe("drop") {
      it("drop(MyList(1, 2, 3, 4, 5),  0) should return MyList(1, 2, 3, 4, 5)") {
        drop(MyList(1, 2, 3, 4, 5),  0) should be(MyList(1, 2, 3, 4, 5))
      }

      it("drop(MyList(1, 2, 3, 4, 5),  -1) should raise an Exception") {
        intercept[InvalidArgumentException] {drop(MyList(1, 2, 3, 4, 5),  -1)}
      }

      it("drop(MyList(1, 2, 3, 4, 5),  3) should return MyList(4, 5)") {
        drop(MyList(1, 2, 3, 4, 5),  3) should be(MyList(4, 5))
      }

      it("drop(MyList(),  3) should return MyList(") {
        drop(MyList(),  3) should be(MyList())
      }
    }

    describe("dropWhile") {
      it("dropWhile(MyList(), (x: Int) => true) should return MyList()") {
        dropWhile(MyList(), (x: Int) => true) should be (MyList())
      }

      it("dropWhile(MyList(5, 4, 3, -100, -200, -3000), (x: Int) => x > 0) should return MyList(-100, -200, -3000)") {
        dropWhile(MyList(5, 4, 3, -100, -200, -3000), (x: Int) => x > 0) should be (MyList(-100, -200, -3000))
      }

      it("dropWhile(MyList(3, 20, 10), (x: Int) => x > 0) should return MyList()") {
        dropWhile(MyList(3, 20, 10), (x: Int) => x > 0) should be (MyList())
      }

      it("dropWhile(MyList(3, 20, 10), (x: Int) => x < 0) should return MyList(3, 20, 10)") {
        dropWhile(MyList(3, 20, 10), (x: Int) => x < 0) should be (MyList(3, 20, 10))
      }
    }
  }
}
