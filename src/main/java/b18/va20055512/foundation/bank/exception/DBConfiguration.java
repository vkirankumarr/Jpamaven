/*
 * package b18.va20055512.foundation.bank.exception;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement;
 * import java.util.Properties;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.boot.context.properties.ConfigurationProperties; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.Primary;
 * 
 * import com.sun.istack.NotNull;
 * 
 * import oracle.jdbc.pool.OracleDataSource;
 * 
 * @Configuration
 * 
 * @ConfigurationProperties(prefix = "datasource.demo") public class
 * DBConfiguration { private static final Logger LOGGER =
 * LoggerFactory.getLogger(DBConfiguration.class); OracleDataSource dataSource =
 * null;;
 * 
 * @NotNull private String username;
 * 
 * @NotNull private String password;
 * 
 * @NotNull private String url;
 * 
 * @NotNull private String initialSize;
 * 
 * @NotNull private String inactivityTimeout;
 * 
 * @NotNull private String timeToLiveTimeout;
 * 
 * @NotNull private String oracleJDBCReadTimeout;
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public void setUrl(String url) { this.url = url; }
 * 
 * public String getInitialSize() { return initialSize; }
 * 
 * public void setInitialSize(String initialSize) { this.initialSize =
 * initialSize; }
 * 
 * public String getInactivityTimeout() { return inactivityTimeout; }
 * 
 * public void setInactivityTimeout(String inactivityTimeout) {
 * this.inactivityTimeout = inactivityTimeout; }
 * 
 * public String getTimeToLiveTimeout() { return timeToLiveTimeout; }
 * 
 * public void setTimeToLiveTimeout(String timeToLiveTimeout) {
 * this.timeToLiveTimeout = timeToLiveTimeout; }
 * 
 * public String getOracleJDBCReadTimeout() { return oracleJDBCReadTimeout; }
 * 
 * public void setOracleJDBCReadTimeout(String oracleJDBCReadTimeout) {
 * this.oracleJDBCReadTimeout = oracleJDBCReadTimeout; }
 * 
 * @Bean(name = "citpjsandboxl101")
 * 
 * @Primary DataSource getDataSource() throws SQLException { dataSource = new
 * OracleDataSource(); dataSource.setUser(username);
 * dataSource.setPassword(password); dataSource.setURL(url);
 * dataSource.setImplicitCachingEnabled(true);
 * dataSource.setFastConnectionFailoverEnabled(true); Properties prop = new
 * Properties(); prop.put("oracle.jdbc.ReaTimeout", "OracleJDBCReadTimeOut");
 * dataSource.setConnectionProperties(prop);
 * 
 * Properties cacheProps = new Properties();
 * cacheProps.setProperty("InitialLimit", initialSize);
 * cacheProps.setProperty("InactivityTimeout", inactivityTimeout);
 * cacheProps.setProperty("YimeToLiveTimeout", timeToLiveTimeout);
 * cacheProps.setProperty("ValidateConnection", "true");
 * dataSource.setConnectionCacheProperties(cacheProps); return dataSource; }
 * 
 * public Connection getConnection() throws SQLException { if (dataSource ==
 * null) { getDataSource(); } Connection conn = null; try { conn =
 * dataSource.getConnection(); LOGGER.info("connection Established"); } catch
 * (SQLException sqlException) { System.out.println("101010");
 * LOGGER.error("connection Established"); throw sqlException; } return conn; }
 * 
 * public void closeConnection(Connection conn) throws SQLException { try { if
 * (conn != null) { conn.close(); } LOGGER.info("connection closed"); } catch
 * (SQLException se) { LOGGER.error(se.getMessage(), se); } }
 * 
 * public void closeResultSet(ResultSet rs) throws SQLException { try { if (rs
 * != null) { rs.close(); } LOGGER.info("ResultSet closed"); } catch
 * (SQLException se) { LOGGER.error(se.getMessage(), se); } }
 * 
 * public void closeStatement(Statement statement) throws SQLException { try {
 * if (statement != null) { statement.close(); }
 * LOGGER.info("Statement closed"); } catch (SQLException se) {
 * LOGGER.error(se.getMessage(), se); } }
 * 
 * public void closePrepStatement(PreparedStatement prepStatement) throws
 * SQLException { try { if (prepStatement != null) { prepStatement.close(); }
 * LOGGER.info("Statement closed"); } catch (SQLException se) {
 * LOGGER.error(se.getMessage(), se); } }
 * 
 * }
 */