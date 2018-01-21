# activemq-parent
centos 7 安装 activemq
1.系统必须先安装jdk,因为activemq是一个web应用
2.下载activemq 到服务器
这里是先下载好，在上传到centos7系统

2.1 创建文件夹
mkdir /usr/local/service

2.2 上传安装到这个文件夹中

2.3解压

tar -zxvf apache-activemq-5.14.1-bin.tar.gz

cd bin

2.4 启动

./activemq start

2.5查看是否启动成功

netstat -anp|grep 61616

3 开启activemq 需要的端口 8161、61616
firewall-cmd --permanent --zone=public --add-port=8161/tcp

firewall-cmd --permanent --zone=public --add-port=61616/tcp

firewall-cmd --reload

4. 进行访问界面
http://安装的IP:8161/admin/
默认账户 admin = amdin


修改用户信息编辑 conf/jetty-realm.properties 即可

5.设置脚本启动
cd /etc/init.d  
vi activemq  



5.1输入以下内容

export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_121 
export CATALINA_HOME=/usr/lo:qcal/service/apache-activemq-5.13.0
  
case $1 in  
    start)  
        sh $CATALINA_HOME/bin/activemq start  
    ;;  
    stop)  
    sh $CATALINA_HOME/bin/activemq stop  
    ;;  
    restart)  
    sh $CATALINA_HOME/bin/activemq stop  
    sleep 1  
    sh $CATALINA_HOME/bin/activemq start  
    ;;  
   
esac  
exit 0  


5.对activemq授权
chmod 777 activemq  

6.设置开机启动
chkconfig  activemq  on  
service  activemq  start  

