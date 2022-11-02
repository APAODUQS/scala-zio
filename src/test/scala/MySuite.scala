import zio.*
import zio.test.*
import zio.test.Assertion.*
import requests.Response

object MySuite extends ZIOSpecDefault {
def spec = suite("My Suite") (
      test("example test that fails") {
        val obtained = 42
        val expected = 41
        assert(obtained)(equalTo(expected))
      },
      test("example test that succeeds") {
        for {
          obtained <- ZIO.succeed(42)
          expected <- ZIO.succeed(42)
        } yield assert(obtained)(equalTo(expected))
      },
      test("Doing a http Request") {
        for {
          user <- ZIO.succeed("Paola")
          r <- ZIO.succeed(requests.get(s"http://localhost:8085/greet/$user"))
        } yield assert(r.statusCode)(equalTo(200))  && assert(r.text())(equalTo(s"Hello $user!"))
      }      
  )
}
