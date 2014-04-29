/**
 *
 */
package basics.oo.zother

/**
 * @author dongjie.shi
 *
 */
abstract class Simulation {
  type Action = () => Unit

  case class WorkItem(time: Int, action: Action)

  private var curtime = 0
  private var agenda: List[WorkItem] = List()

  def currentTime: Int = curtime
  def afterDelay(delay: Int)(block: => Unit) {
    val item = WorkItem(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }
  def run() {

  }

  private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem] = {
    if (ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(ag.tail, item)
  }
  private def next() {
    (agenda: @unchecked) match {
      case item :: rest =>
        agenda = rest
        curtime = item.time
        item.action()
    }
  }
}

abstract class BasicCircuitSimulation extends Simulation {
  def InverterDelay: Int
  def AndGateDelay: Int
  def OrGateDelay: Int

  class Wire {
    private var sigVal = false
    private var actions: List[Action] = List()

    def getSignal = sigVal
    def setSignal(s: Boolean) = {
      if (s != sigVal) {
        sigVal = s
        actions foreach (_())
      }
    }
    def addAction(a: Action) = {
      actions = a :: actions
      a()
    }
  }

  def inverter(input: Wire, output: Wire) = {
    def invertAction() {
      val inputSig = input.getSignal
      afterDelay(InverterDelay){
        output setSignal !inputSig
      }
    }
    input addAction invertAction
  }
}