package com.morgenrete.query.udt

import com.morgenrete.config.keyspace.KeyspaceConf
import com.morgenrete.config.udt._
import org.mockito.Mockito._
import org.scalatest.mock._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by rwadowski on 14.05.16.
 */
class UDTQuerySpec extends FlatSpec with Matchers with MockitoSugar {

  it should "create CREATE query" in {

    val keyspaceName = "test"
    val keyspaceConfMock = mock[KeyspaceConf]

    when(keyspaceConfMock.name).thenReturn(keyspaceName)

    val conf = UDTConf("create", "MyType", List(UDTMember("field_1", "text"), UDTMember("field_2", "bigint")), existsClause = true)
    val query = new UDTQuery(conf)
    val text = query.text(keyspaceConfMock)

    val expected =
      s"""CREATE TYPE IF NOT EXISTS $keyspaceName.MyType (
         |field_1 TEXT,
         |field_2 BIGINT
         |);""".stripMargin

    text should equal (expected)
  }

  it should "create ALTER query" in {
    val keyspaceName = "test"
    val keyspaceConfMock = mock[KeyspaceConf]

    when(keyspaceConfMock.name).thenReturn(keyspaceName)

    val conf = UDTConf("alter", "MyType", List(UDTMember("field_1", "text"), UDTMember("field_2", "bigint")), existsClause = true)
    val query = new UDTQuery(conf)
    val text = query.text(keyspaceConfMock)

    val expected =
      s"""ALTER TYPE IF NOT EXISTS $keyspaceName.MyType (
         |field_1 TEXT,
         |field_2 BIGINT
         |);""".stripMargin

    text should equal (expected)
  }

  it should "create DROP query" in {
    val keyspaceName = "test"
    val keyspaceConfMock = mock[KeyspaceConf]

    when(keyspaceConfMock.name).thenReturn(keyspaceName)

    val conf = UDTConf("drop", "MyType", List.empty, existsClause = true)
    val query = new UDTQuery(conf)
    val text = query.text(keyspaceConfMock)

    val expected =
      s"""DROP TYPE IF NOT EXISTS $keyspaceName.MyType;""".stripMargin

    text should equal (expected)
  }
}
