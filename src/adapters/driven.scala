object RepositoryFactory {
  def getMockRateRepository(): RateRepository = new MockRateRepository()
}
//driven adapter
class MockRateRepository extends RateRepository {
  override def getRate(amount: Double): Double = 0.05
}
