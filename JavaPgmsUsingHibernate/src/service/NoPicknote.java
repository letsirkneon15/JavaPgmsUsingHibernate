package service;


	import org.eclipse.jetty.server.Server;
	import org.eclipse.jetty.servlet.ServletContextHandler;
	import org.eclipse.jetty.servlet.ServletHolder;
	import org.eclipse.jetty.util.resource.Resource;
	import org.eclipse.jetty.util.thread.QueuedThreadPool;


import com.sun.jersey.spi.container.servlet.ServletContainer;


	public class NoPicknote {
		
		
			public static void main(String[] args) {
				
			    try{
					//Server server = new Server(8999);
					ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
					servletHolder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", 
							"com.sun.jersey.api.core.PackagesResourceConfig");
					// specify where resources are located
					servletHolder.setInitParameter("com.sun.jersey.config.property.packages", 
							"com.muratames.usso.resource");
		 
					ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
					context.setContextPath("/");
					context.setBaseResource(Resource.newSystemResource("./"));
					context.addServlet(servletHolder, "/*");
		 
					QueuedThreadPool queuedThreadPool = new QueuedThreadPool(10);
					queuedThreadPool.setName("API Serve");
		 
					//Server server = new Server(queuedThreadPool);
					Server server = new Server(Integer.parseInt(args[0]));
		 
					server.setHandler(context);
		 
					//ServerConnector connector = new ServerConnector(server);
					//connector.setPort(8999);
					//server.addConnector(connector);
					server.setThreadPool(queuedThreadPool);
		 
					server.start();
					server.join();
		 
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			    	    
			}

}
