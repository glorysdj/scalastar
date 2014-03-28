package oo.traits

/**
 * @author dongjie.shi
 *
 */
case class User(val username: String, val password: String)

trait UserRepositoryComponent {
  val userRepository: UserRepository
  class UserRepository {
    def authenticate(user: User): User = {
      println("authenticating user: " + user)
      user
    }
    def create(user: User) = println("creating user: " + user)
    def delete(user: User) = println("deleting user: " + user)
  }
}

trait UserServiceComponent { this: UserRepositoryComponent =>
  val userService: UserService
  class UserService {
    def authenticate(username: String, password: String): User =
      userRepository.authenticate(new User(username, password))
    def create(username: String, password: String) =
      userRepository.create(new User(username, password))
    def delete(user: User) = userRepository.delete(user)
  }
}

object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent {
  val userRepository = new UserRepository
  val userService = new UserService
}

object selfAnnotationDemo extends App {
  val service = ComponentRegistry.userService
  println(service.authenticate("hello", "world"))
  service.create("hello", "world")
  service.delete(new User("hello", "world"))
}