data "aws_availability_zones" "available" {}

module "vpc" { #A
  source                           = "terraform-aws-modules/vpc/aws"
  version                          = "5.5.0"

  name                             = "${var.namespace}-vpc"
  cidr                             = "10.0.0.0/16"

  azs                              = data.aws_availability_zones.available.names
  private_subnets                  = ["10.0.1.0/24", "10.0.2.0/24", "10.0.3.0/24"]
  public_subnets                   = ["10.0.101.0/24", "10.0.102.0/24", "10.0.103.0/24"]
  # stress_test_subnets              = ["10.0.201.0/24"]
  database_subnets                 = ["10.0.21.0/24", "10.0.22.0/24", "10.0.23.0/24"]
  # elasticache_subnets              = ["10.0.31.0/24", "10.0.32.0/24"]

  create_database_subnet_group     = true
  enable_nat_gateway               = true
  single_nat_gateway               = true
}

# module "lb_sg" {
#   source = "terraform-in-action/sg/aws"
#   vpc_id = module.vpc.vpc_id
#   ingress_rules = [{
#     port        = 80
#     cidr_blocks = ["0.0.0.0/0"]
#   }]
# }

module "websvr_sg" {
  source = "terraform-in-action/sg/aws"
  vpc_id = module.vpc.vpc_id
  
  # 1. inbound
  # Allows incoming traffic on ports 80, 443, 8080, and 9090 from anywhere (0.0.0.0/0)
  ingress_rules = [
    {
      port        = 80 # http 트래픽용 
	  cidr_blocks = ["0.0.0.0/0"]
    },
    {
      port        = 443 # https 트래픽용
	  cidr_blocks = ["0.0.0.0/0"]
    },
    {
      port            = 8080
      /* security_groups = [module.lb_sg.security_group.id] */
      cidr_blocks = ["0.0.0.0/0"] # load balancer 없이 부하 테스트를 위한 설정 변경
    },
    {
      port        = 9090 
      cidr_blocks = ["0.0.0.0/0"]
    },
  ]
  # 2. outbound
  # Allows all outbound traffic (0.0.0.0/0)
  egress_rules = [
    # 아웃바운드 규칙 단순화, 모든 아웃바운드 트래픽을 허용 for monitoring server
    {
      port        = 0
      protocol    = "-1"
      cidr_blocks = ["0.0.0.0/0"]
    },
  ]
}

module "db_sg" {
  source = "terraform-in-action/sg/aws"
  vpc_id = module.vpc.vpc_id

  # 1. inbound
  # Allows incoming traffic on ports 3306 from anywhere (0.0.0.0/0)
  ingress_rules = [
    {
        port            = 3306
        # 1. open only to websvr_sg, prometheus_sg. 
        # 2. whether public/private subnet group does not matter 
        security_groups = [module.websvr_sg.security_group.id, module.prometheus_sg.security_group.id]  
    }
  ]
}

module "prometheus_sg" {
  source = "terraform-in-action/sg/aws"
  vpc_id = module.vpc.vpc_id

  # 1. inbound
  # Allows incoming traffic on ports 80, 443, 3000, 8080, and 9090 from anywhere (0.0.0.0/0)
  ingress_rules = [
    {
      port        = 80 # http 트래픽용 
	  cidr_blocks = ["0.0.0.0/0"]
    },
    {
      port        = 443 # https 트래픽용
	  cidr_blocks = ["0.0.0.0/0"]
    },
    {
      port        = 3000 # grafana 기본 포트
	  cidr_blocks = ["0.0.0.0/0"]
    },
    {
      port        = 8080  # PMM 서버용 포트 (docker에서 pmm:2 실행시, -p 8080:80 파라미터를 넣었기 때문.)
      cidr_blocks = ["0.0.0.0/0"]
    },
    {
      port        = 9090
      cidr_blocks = ["0.0.0.0/0"]
    },
  ]
  
  # 2. outbound
  # Allows all outbound traffic (0.0.0.0/0)
  egress_rules = [
    # 아웃바운드 규칙 단순화, 모든 아웃바운드 트래픽을 허용 for monitoring server
    {
      port        = 0
      protocol    = "-1"
      cidr_blocks = ["0.0.0.0/0"]
    },
    # {
    #   port        = 80
	  # cidr_blocks = ["0.0.0.0/0"]
    # },
    # {
    #   port        = 443
	  # cidr_blocks = ["0.0.0.0/0"]
    # },
    # {
    #   port        = 3000
	  # cidr_blocks = ["0.0.0.0/0"]
    # },
    # {
    #   port        = 3306  # MySQL 포트
    #   cidr_blocks = ["0.0.0.0/0"]
    # },
    # {
    #   port        = 8080
	  # cidr_blocks = ["0.0.0.0/0"]
    # },
    # {
    #   port        = 9090
	  # cidr_blocks = ["0.0.0.0/0"]
    # },
  ]
}

module "stress_test_svr_sg" {
  source = "terraform-in-action/sg/aws"
  vpc_id = module.vpc.vpc_id
  
  ingress_rules = [
    {
      port        = 0
      protocol    = "-1"
      cidr_blocks = ["0.0.0.0/0"]
    }
  ]
  egress_rules = [
    {
      port        = 0
      protocol    = "-1"
      cidr_blocks = ["0.0.0.0/0"]
    }
  ]
}