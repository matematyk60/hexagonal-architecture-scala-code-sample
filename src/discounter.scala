//app/driving port
class Discounter(val rateRepository: RateRepository) {
  def discount(amount: Double): Double = amount * rateRepository.getRate(amount)
}

//driven port
trait RateRepository {
  def getRate(amount: Double): Double
}
