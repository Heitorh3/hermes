# Hermes


# DataSource Apache tomcat

Arquivo context.xml do servidor

 	<Resource name="jdbc/sigemDB" auth="Container"
	    factory="org.apache.naming.factory.BeanFactory" 
	    type="com.mchange.v2.c3p0.ComboPooledDataSource"
	    driverClass="com.mysql.jdbc.Driver" 
	    jdbcUrl="jdbc:mysql://localhost:3306/sigemdb"
	    user="root" 
	    password="*******" 
	    minPoolSize="3" 
	    maxPoolSize="3"/>

Arquivo web.xml da aplicação

	<resource-ref>
		<description>DB Connection</description>
		<res-ref-name>jdbc/sigemDB</res-ref-name>
		<res-type>javax.sql.DataSource</res-type>
		<res-auth>Container</res-auth>
	</resource-ref>	    