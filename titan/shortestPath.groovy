conf = new BaseConfiguration()
conf.setProperty("gremlin.graph", "com.thinkaurelius.titan.core.TitanFactory")
conf.setProperty("storage.backend", "hbase")
conf.setProperty("storage.hostname", "hadoop-16.csse.rose-hulman.edu")
conf.setProperty("storage.batch-loading", true)
conf.setProperty("storage.hbase.ext.zookeeper.znode.parent","/hbase-unsecure")
conf.setProperty("storage.hbase.ext.hbase.zookeeper.property.clientPort", 2181)
conf.setProperty("cache.db-cache",true)
conf.setProperty("cache.db-cache-clean-wait", 20)
conf.setProperty("cache.db-cache-time", 180000)
conf.setProperty("cache.db-cache-size", 0.5)
conf.setProperty("storage.hbase.table", "linksSample")
graph = TitanFactory.open(conf);
t=graph.traversal();
t.V().has("pageID", "a").repeat(out().simplePath()).until(has('pageID','b')).path().by('pageID').limit(1);
