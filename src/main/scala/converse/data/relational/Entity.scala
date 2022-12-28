package converse.data.relational

import slick.jdbc.PostgresProfile.api._

object Entity {

  case class User(username: String, userId: String,
                  firstName: String, lastName: String,
                  domainId: Int)

  class UserTable(tag: Tag) extends Table[User](tag, None, "TBL_USER") {
    override def * =
      (username, userId, firstName, lastName, domainId) <> (User.tupled, User.unapply)

    val username: Rep[String] = column[String]("username")
    val userId: Rep[String] = column[String]("user_id")
    val firstName: Rep[String] = column[String]("first_name")
    val lastName: Rep[String] = column[String]("last_name")
    val domainId: Rep[Int] = column[Int]("domain_id")
  }

  case class Group(groupName: String, groupId: String, domainId: Int)

  class GroupTable(tag: Tag) extends Table[Group](tag, None, "TBL_GROUP") {
    override def * =
      (groupName, groupId, domainId) <> (Group.tupled, Group.unapply)

    val groupName: Rep[String] = column[String]("group_name")
    val groupId: Rep[String] = column[String]("group_id")
    val domainId: Rep[Int] = column[Int]("domain_id")
  }

}
