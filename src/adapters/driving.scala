//> using dep org.scala-lang.modules::scala-swing:3.0.0
import scala.swing._
import scala.swing.event._

//driving adapter
object DicounterGUI extends SimpleSwingApplication {
  // configuration
  val app = new Discounter(RepositoryFactory.getMockRateRepository())

  def top: Frame = new MainFrame {
    title = "Simple Scala GUI"

    // Create components
    val inputField   = new TextField { columns = 20 }
    val outputLabel  = new Label { text = "" }
    val submitButton = new Button { text = "Submit" }

    // Set up the layout
    contents = new BoxPanel(Orientation.Vertical) {
      contents += inputField
      contents += submitButton
      contents += outputLabel
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }

    // Listen for button click
    listenTo(submitButton)
    reactions += { case ButtonClicked(_) =>
      // Update label with the input field's text
      val discount = app.discount(inputField.text.toDouble)
      outputLabel.text = s"Your discount is: ${discount}"
    }
  }
}
