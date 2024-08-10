//> using test.dep org.scalameta::munit::1.0.0

//driving adapter
class DiscounterTest extends munit.FunSuite {

  case class DiscountTestCase(amount: Double, expectedDiscount: Double)

  val testCases = DiscountTestCase(amount = 100, expectedDiscount = 5) ::
    DiscountTestCase(amount = 200, expectedDiscount = 10) :: Nil

  test("Discount is granted correctly") {
    val app = buildDiscounter()
    testCases.foreach { case DiscountTestCase(amount, expectedDiscount) =>
      assertEquals(app.discount(amount), expectedDiscount)
    }
  }

  private def buildDiscounter() = new Discounter(
    RepositoryFactory.getMockRateRepository()
  )
}
