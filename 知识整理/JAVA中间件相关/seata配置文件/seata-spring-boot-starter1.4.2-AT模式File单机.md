### server端配置 - redis作为注册中心 配置以文件方式读取
#### registry.conf
```
registry {
  type = "redis"

  redis {
    serverAddr = "xxxx:6379"
    db = 0
    password = ""
    cluster = "default"
    timeout = 0
  }
}

config {
  type = "file"
  file {
    name = "file.conf"
  }
}
```

#### file.conf
```
transport {
  # tcp, unix-domain-socket
  type = "TCP"
  #NIO, NATIVE
  server = "NIO"
  #enable heartbeat
  heartbeat = true
  # the client batch send request enable
  enableClientBatchSendRequest = false
  #thread factory for netty
  threadFactory {
    bossThreadPrefix = "NettyBoss"
    workerThreadPrefix = "NettyServerNIOWorker"
    serverExecutorThreadPrefix = "NettyServerBizHandler"
    shareBossWorker = false
    clientSelectorThreadPrefix = "NettyClientSelector"
    clientSelectorThreadSize = 1
    clientWorkerThreadPrefix = "NettyClientWorkerThread"
    # netty boss thread size
    bossThreadSize = 1
    #auto default pin or 8
    workerThreadSize = "default"
  }
  shutdown {
    # when destroy server, wait seconds
    wait = 3
  }
  serialization = "seata"
  compressor = "none"
}
service {
  #transaction service group mapping
  vgroupMapping.my_test_tx_group = "default"
  #only support when registry.type=file, please don't set multiple addresses
  default.grouplist = "127.0.0.1:8091"
  #degrade, current not support
  enableDegrade = false
  #disable seata
  disableGlobalTransaction = false
}
## transaction log store, only used in server side
store {
  ## store mode: file、db
  mode = "db"
  ## file store property
  file {
    ## store location dir
    dir = "sessionStore"
    # branch session size , if exceeded first try compress lockkey, still exceeded throws exceptions
    maxBranchSessionSize = 16384
    # globe session size , if exceeded throws exceptions
    maxGlobalSessionSize = 512
    # file buffer size , if exceeded allocate new buffer
    fileWriteBufferCacheSize = 16384
    # when recover batch read size
    sessionReloadReadSize = 100
    # async, sync
    flushDiskMode = async
  }

  ## database store property
  db {
    ## the implement of javax.sql.DataSource, such as DruidDataSource(druid)/BasicDataSource(dbcp) etc.
    datasource = "druid"
    ## mysql/oracle/postgresql/h2/oceanbase etc.
    dbType = "mysql"
    driverClassName = "com.mysql.cj.jdbc.Driver"
    ## if using mysql to store the data, recommend add rewriteBatchedStatements=true in jdbc connection param
    url = "jdbc:mysql://127.0.0.1:3306/seata?rewriteBatchedStatements=true"
    user = "root"
    password = "88888888"
    minConn = 5
    maxConn = 30
    globalTable = "global_table"
    branchTable = "branch_table"
    lockTable = "lock_table"
    queryLimit = 100
  }
}
## server configuration, only used in server side
server {
  recovery {
    #schedule committing retry period in milliseconds
    committingRetryPeriod = 1000
    #schedule asyn committing retry period in milliseconds
    asynCommittingRetryPeriod = 1000
    #schedule rollbacking retry period in milliseconds
    rollbackingRetryPeriod = 1000
    #schedule timeout retry period in milliseconds
    timeoutRetryPeriod = 1000
  }
  undo {
    logSaveDays = 7
    #schedule delete expired undo_log in milliseconds
    logDeletePeriod = 86400000
  }
  #check auth
  enableCheckAuth = true
  #unit ms,s,m,h,d represents milliseconds, seconds, minutes, hours, days, default permanent
  maxCommitRetryTimeout = "-1"
  maxRollbackRetryTimeout = "-1"
  rollbackRetryTimeoutUnlockEnable = false
  retryDeadThreshold = 130000
}
client {
  rm {
    asyncCommitBufferLimit = 10000
    lock {
      retryInterval = 10
      retryTimes = 30
      retryPolicyBranchRollbackOnConflict = true
    }
    reportRetryCount = 5
    tableMetaCheckEnable = false
    reportSuccessEnable = false
  }
  tm {
    commitRetryCount = 5
    rollbackRetryCount = 5
  }
  undo {
    dataValidation = true
    logSerialization = "kryo"
    logTable = "undo_log"
  }
  log {
    exceptionRate = 100
  }
}
## metrics configuration, only used in server side
metrics {
  enabled = false
  registryType = "compact"
  # multi exporters use comma divided
  exporterList = "prometheus"
  exporterPrometheusPort = 9898
}
```

### 客户端配置 直连server端而非注册中心，配置读取在application.yml

```
seata:  
  enabled: true  
  tx-service-group: my_test_tx_group  
#  enable-auto-data-source-proxy: true  
  #use-jdk-proxy: false  
  client:  
    rm:  
      async-commit-buffer-limit: 1000  
      report-retry-count: 5  
      table-meta-check-enable: false  
      report-success-enable: false  
      lock:  
        retry-interval: 10  
        retry-times: 30  
        retry-policy-branch-rollback-on-conflict: true  
    tm:  
      commit-retry-count: 5  
      rollback-retry-count: 5  
    undo:  
      data-validation: true  
      log-serialization: jackson  
      log-table: undo_log  
    log:  
      exceptionRate: 100  
  service:  
    vgroup-mapping:  
      my_test_tx_group: default  
    grouplist:  
      default: 127.0.0.1:8091  
    #enable-degrade: false  
    #disable-global-transaction: false  transport:  
    shutdown:  
      wait: 3  
    thread-factory:  
      boss-thread-prefix: NettyBoss  
      worker-thread-prefix: NettyServerNIOWorker  
      server-executor-thread-prefix: NettyServerBizHandler  
      share-boss-worker: false  
      client-selector-thread-prefix: NettyClientSelector  
      client-selector-thread-size: 1  
      client-worker-thread-prefix: NettyClientWorkerThread  
      worker-thread-size: default  
      boss-thread-size: 1  
    type: TCP  
    server: NIO  
    heartbeat: true  
    serialization: seata  
    compressor: none  
    enable-client-batch-send-request: true  
  config:  
    type: file  
  registry:  
    type: file  
  application-id: brain-uc
```