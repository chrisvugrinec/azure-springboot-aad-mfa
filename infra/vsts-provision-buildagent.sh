#!/bin/bash
password="HelloWorld123!"
apt-get update
apt -y install docker.io
apt -y install maven
/usr/sbin/useradd -m -d /vsts -p `openssl passwd -1 $password` vsts
# fix needed for vsts on ubuntu 16.04
apt-get install -y libunwind8 libcurl3
apt-get install -y libunwind8 libcurl3 libicu52

apt-get install -y openjdk-8-jdk-headless

# install the kubectl
curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
chmod +x ./kubectl
sudo mv ./kubectl /usr/local/bin/kubectl

# adding user vsts to docker group
usermod -aG docker vsts
sudo -H -u vsts bash -c 'ssh-keygen -t rsa -f  ~/.ssh/id_rsa -P ""'
sudo -H -u vsts bash -c 'mkdir ~/.kube'
sudo -H -u vsts bash -c '/bin/mkdir /vsts/bagent'
sudo -H -u vsts bash -c 'cd /vsts/bagent && wget https://github.com/Microsoft/vsts-agent/releases/download/v2.111.1/vsts-agent-ubuntu.16.04-x64-2.111.1.tar.gz' 
sudo -H -u vsts bash -c 'tar -zxvf /vsts/bagent/vsts-agent-ubuntu.16.04-x64-2.111.1.tar.gz -C /vsts/bagent'
