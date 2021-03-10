## Overview:

This is an example to connect your cloud hosted **Oracle Autonomous database** with **Spring Boot** framework.   

---
## Usage guide:

We assume you already have an Oracle cloud database.

- [Download](https://docs.oracle.com/en-us/iaas/Content/Database/Tasks/adbconnecting.htm#access) 
  your client credentials (_wallet_) for Oracle Autonomous Database.
    
- Unzip your `Wallet_dbname.zip` and copy its path (e.g.: `/home/<user>/<wallet>`).
      
- Replace `<WalletDirectory>` with the path that you copied earlier.  
  Edit in your _application.yml_ or _application.properties_ file:
    
      spring:
        datasource:
          url: "jdbc:oracle:thin:@<db-name>_high?TNS_ADMIN=<wallet-directory>"
---
