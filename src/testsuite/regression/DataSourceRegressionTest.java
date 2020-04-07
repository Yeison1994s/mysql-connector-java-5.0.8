/*
 Copyright (C) 2002-2006 MySQL AB

 This program is free software; you can redistribute it and/or modify
 it under the terms of version 2 of the GNU General Public License as 
 published by the Free Software Foundation.

 There are special exceptions to the terms and conditions of the GPL 
 as it is applied to this software. View the full text of the 
 exception in file EXCEPTIONS-CONNECTOR-J in the directory of this 
 software distribution.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA



 */
package testsuite.regression;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NameParser;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.PooledConnection;

import testsuite.BaseTestCase;
import testsuite.simple.DataSourceTest;

import com.mysql.jdbc.NonRegisteringDriver;
import com.mysql.jdbc.integration.jboss.MysqlValidConnectionChecker;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSourceFactory;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

/**
 * Tests fixes for bugs related to datasources.
 * 
 * @author Mark Matthews
 * 
 * @version $Id: DataSourceRegressionTest.java,v 1.1.2.1 2005/05/13 18:58:38
 *          mmatthews Exp $
 */
public class DataSourceRegressionTest extends BaseTestCase {

	public final static String DS_DATABASE_PROP_NAME = "com.mysql.jdbc.test.ds.db";

	public final static String DS_HOST_PROP_NAME = "com.mysql.jdbc.test.ds.host";

	public final static String DS_PASSWORD_PROP_NAME = "com.mysql.jdbc.test.ds.password";

	public final static String DS_PORT_PROP_NAME = "com.mysql.jdbc.test.ds.port";

	public final static String DS_USER_PROP_NAME = "com.mysql.jdbc.test.ds.user";

	private Context ctx;

	private File tempDir;

	/**
	 * Creates a new DataSourceRegressionTest suite for the given test name
	 * 
	 * @param name
	 *            the name of the testcase to run.
	 */
	public DataSourceRegressionTest(String name) {
		super(name);

		// TODO Auto-generated constructor stub
	}

	/**
	 * Runs all test cases in this test suite
	 * 
	 * @param args
	 */
	public static void maimport eates 
E om.my ats Exp $gtysqlDataSoSataSoSarivertic voYTxp $gtysp $gtysql1ts Exp $gtysq