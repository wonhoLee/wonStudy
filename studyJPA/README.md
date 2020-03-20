# README
## 참고
- CH1 : https://jojoldu.tistory.com/250?category=635883
- CH4 : https://jojoldu.tistory.com/259?category=635883
- CH5 : https://jojoldu.tistory.com/263?category=635883

## CH4
- AWS EC2 설정
  - 생성 : Amazon Linux -> t2.micro(프리티어) -> 네트워크, 서브넷 -> 스토리지(30GB - 프리티어) -> 태그 -> 보안그룹 구성(22 포트 인바운드 IP픽스 하여 통제할것) -> 키페어 생성 Modal
  - IP등록 : Elastic IP -> 새주소할당 -> 주소연결 -> 생성한 인스턴스 IP연결
  - EC2터미널접속
- AWS RDS 설정
  - 생성 : MariaDB -> 개발/테스트(프리티어) -> t2.micro -> 20G
  - 보안그룹설정(인바운드설정 - EC2 & 개발장소IP) -> RDS에 적용
  - DB파라미터그룹 -> 생성 -> character set(UTF-8) -> RDS에 적용
  - Clien 접속 : show variables like 'c%'; -> ALTER DATABASE 본인database CHARACTER SET =  utf8' COLLATE = 'utf8_general_ci';

## CH5
- JAVA 설치
cd /applications
sudo wget --no-check-certificate https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz
sudo tar zxvf openjdk-11.0.2_linux-x64_bin.tar.gz
- GIT 설치
sudo yum install git
git --version
mkdir app
mkdir app/git
git clone https://github.com/프로젝트주소.git
./gradlew test
- 배포 스크립트
- 서비스 시작 및 외부에서 서비스 접속