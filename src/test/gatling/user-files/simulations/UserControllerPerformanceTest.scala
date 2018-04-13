import _root_.io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import com.typesafe.config._

class UserControllerPerformanceTest extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:8080")
    .acceptHeader("application/json")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Gatling")

  val scn = scenario("UserControllerPerformanceTest")
    .repeat(10) {
      exec(http("GET /api/v1/users").get("/api/v1/users"))
    }

  setUp(
    scn.inject(atOnceUsers(1000))).protocols(httpProtocol)
}