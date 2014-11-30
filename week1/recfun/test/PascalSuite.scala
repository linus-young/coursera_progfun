package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }
  
  
  test("pascal: some cases") {
    assert(pascal(2,3) === 3)
    assert(pascal(1,4) === 4)
    assert(pascal(2,4) === 6)
    assert(pascal(3,4) === 4)
    assert(pascal(0,0) === 1)
    assert(pascal(0,3) === 1)
    assert(pascal(2,2) === 1)
  }
}