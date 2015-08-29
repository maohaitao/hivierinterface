CREATE TABLE `pc_brand_info` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑/业务ID',
`brand_name_cn` varchar(255) NOT NULL COMMENT '品牌中文名',
`brand_name_en` varchar(255) NOT NULL COMMENT '品牌英文名',
`b_status` int(2) NULL DEFAULT 1 COMMENT '状态 1 正常 2下线',
`brand_style` varchar(255) NULL COMMENT '品牌类型',
`avg_price` double(8,2) NULL COMMENT '人均消费',
`logo_url` varchar(255) NOT NULL COMMENT 'logo图标',
`web_url` varchar(255) NULL COMMENT '网址',
`popularity` double(4,2) NULL COMMENT '人气',
`descrption` text NOT NULL COMMENT '描述',
`other` varchar(255) NULL COMMENT '其他信息',
`create_time` datetime NULL,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='品牌基础信息表'
;


CREATE TABLE `buyer_goods` (
`goods_id` int(10) UNSIGNED NOT NULL COMMENT '商品ID',
`buyer_id` int(10) UNSIGNED NOT NULL COMMENT '买手ID',
`type` int(1) NOT NULL COMMENT '商家属性：0代理，1直营，2加盟',
`create_time` datetime NULL,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`goods_id`, `buyer_id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='品牌与商铺之间的关联'
;


CREATE TABLE `pc_local_info` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑/业务ID',
`prov_id` int(10) NOT NULL COMMENT '省份ID',
`local_name` varchar(24) NOT NULL COMMENT '地域名称(如:广州)',
`local_short` varchar(16) NOT NULL COMMENT '简写(如:gz)',
`nick_name` varchar(32) NOT NULL COMMENT '昵称(如:羊城,)',
`descrption` text NOT NULL COMMENT '描述',
`create_time` datetime NOT NULL,
`update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='地域路由表'
;


CREATE TABLE `pc_buyer_info` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商铺ID',
`b_name` varchar(100) NOT NULL COMMENT '买手名称',
`s_name` varchar(64) NULL COMMENT '店铺名称',
`province_name` varchar(50) NOT NULL COMMENT '省份',
`city_name` varchar(50) NOT NULL COMMENT '城市',
`address` text NOT NULL COMMENT '商户地址（精确到路之后更精确的地址）',
`avg_price` double(8,2) NULL COMMENT '人均价格',
`b_status` int(2) NOT NULL COMMENT '状态 1 新建 2 审核中 3 审核通过 4 审核不通过 5 黑名单',
`b_brand_type` int(2) NULL DEFAULT 1 COMMENT ' 店铺类型:1 多品牌 2 单品 3 特色 4其他',
`b_type` varchar(50) NULL COMMENT '商铺类型(如:鞋类,眼镜\\衣服)',
`b_style` varchar(255) NULL COMMENT '店铺小风格',
`b_crowd` varchar(64) NULL COMMENT '适合人群',
`b_phone` varchar(20) NOT NULL COMMENT '商铺电话',
`b_logo` varchar(255) NULL COMMENT '店铺的logo信息',
`govauth` int(2) NOT NULL DEFAULT 0 COMMENT '是否官网认证0 未认证 1 认证',
`genuineauth` int(2) NOT NULL DEFAULT 0 COMMENT '正品认证 0 未认证 1 认证',
`shippingauth` int(2) NOT NULL DEFAULT 0 COMMENT '官网物流认证 0未认证 1 认证',
`descrption` text NULL COMMENT '描述',
`popularity` double(4,2) NULL COMMENT '人气',
`create_time` datetime NULL COMMENT '商家进驻时间',
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`other` varchar(255) NULL COMMENT '其他信息',
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='买手基础信息'
;


CREATE TABLE `pc_cate_info` (
`id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
`cate_name` varchar(255) NOT NULL COMMENT '类名称',
`cate_type` int(10) UNSIGNED NOT NULL COMMENT '0根分类 1为子分类',
`pre_id` int(10) NOT NULL COMMENT '父类分类ID',
`c_status` int(10) NOT NULL COMMENT '状态 1可以用 2 停用',
`priority` int(2) NULL DEFAULT 1 COMMENT '优先级别,越小越优先',
`description` text NOT NULL COMMENT '描述',
`create_time` datetime NOT NULL,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='品牌对应品类基础信息'
;


CREATE TABLE `pc_province_info` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑/业务ID',
`prov_name` varchar(24) NOT NULL COMMENT '省份名称(如:广东)',
`prov_short` varchar(16) NOT NULL COMMENT '简写(如:gd)',
`nick_name` varchar(16) NULL COMMENT '简称(如:粤)',
`country` varchar(32) NOT NULL COMMENT '国家',
`descrption` text NOT NULL COMMENT '描述',
`create_time` datetime NOT NULL,
`update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='省份路由表'
;


CREATE TABLE `goods_info` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
`sku_id` varchar(10) NOT NULL COMMENT '商品SKUID',
`icon` varchar(255) NULL COMMENT '图片的icon',
`goods_name` varchar(255) NOT NULL COMMENT '商品名称',
`cate_id` int(10) NOT NULL COMMENT '大类名称',
`g_status` int(2) NOT NULL DEFAULT 1 COMMENT '状态 1 新建 2 审核 3 上线 4 下线',
`g_src` int(2) NOT NULL DEFAULT 1 COMMENT '商品来源,1专柜代购 2 官网 3 经销商 4 员工价格',
`serven` int(2) NOT NULL DEFAULT 0 COMMENT '7天包退 0 否 1 是',
`invoice` int(2) NOT NULL DEFAULT 0 COMMENT '是否有发票 0 否 1是',
`brand_id` int(10) UNSIGNED NOT NULL COMMENT '品牌ID',
`guide_price` decimal(10,2) NOT NULL COMMENT '贴牌指导价，精确到分',
`final_price` decimal(10,2) NOT NULL DEFAULT 0 COMMENT '最终价格,精确',
`pur_price` decimal(10,2) NOT NULL DEFAULT 0 COMMENT '代购费用',
`shipping_price` decimal(10,2) NOT NULL DEFAULT 0 COMMENT '物流费用,默认免运费',
`color` varchar(50) NOT NULL,
`material` varchar(255) NOT NULL,
`size` varchar(10) NOT NULL,
`season` varchar(64) NULL COMMENT '季节',
`g_year` varchar(64) NULL COMMENT '商品年份 如:2015',
`description` text NOT NULL COMMENT '商品描述',
`other` varchar(255) NULL COMMENT '其他信息',
`create_time` datetime NOT NULL,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='商品基础信息'
;


CREATE TABLE `brand_cate` (
`cate_id` int(10) UNSIGNED NOT NULL COMMENT '品类ID',
`brand_id` int(10) UNSIGNED NOT NULL,
`c_status` int(1) NOT NULL DEFAULT 1 COMMENT '状态：1正常，0待定',
`create_time` datetime NULL,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`cate_id`, `brand_id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='品类与品牌关联'
;


CREATE TABLE `pc_banner_info` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商铺ID',
`b_name` varchar(100) NOT NULL COMMENT '名称',
`priority` int(2) NULL DEFAULT 1 COMMENT '优先级别(越小越优先)',
`b_status` int(2) NOT NULL COMMENT '状态 1 新建 2 审核中 3 审核通过 4 审核不通过 5 失效',
`act_type` int(2) NOT NULL DEFAULT 1 COMMENT '操作处理：1 web view 2 intent 3 浏览器打开',
`act_url` varchar(255) NOT NULL COMMENT '商铺电话',
`b_logo` varchar(255) NOT NULL COMMENT 'banner的图片地址',
`descrption` text NULL COMMENT '描述',
`create_time` datetime NULL COMMENT '商家进驻时间',
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`other` varchar(255) NULL COMMENT '其他信息',
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='焦点(banner)基础信息'
;


CREATE TABLE `pc_src_item` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商铺ID',
`type_id` int(10) NULL COMMENT '虚拟的资源ID',
`type_name` varchar(100) NOT NULL COMMENT '节点名称',
`seq` int(2) NULL COMMENT '排序',
`datatype` int(2) NULL DEFAULT 1 COMMENT '数据类型 1 挂载分类 2 具体数据',
`background` varchar(128) NULL COMMENT '背景图',
`moreid` int(2) NULL DEFAULT 0 COMMENT '是否展示更多 0 不展示 1展示',
`i_status` int(2) NOT NULL DEFAULT 1 COMMENT '状态 1 新建 2 上线 3下线',
`showtitle` int(2) NOT NULL DEFAULT 0 COMMENT '是否展示标题:0否 1是',
`layouts` int(2) NULL COMMENT '排版格式 1横向 2纵向',
`cicon` varchar(255) NULL,
`icon` varchar(255) NULL COMMENT '小图标',
`viewtype` int(2) NOT NULL COMMENT '动作类型：datatype=1 1 ：列表展现分类；2：tab栏展现分类；3：图标+文字并排排列展现(顶级分类)；4：按钮形式tab栏；datatype=2 1 ：双栏两列；2 ：格子排版；3:一栏一列；',
`descrption` text NULL COMMENT '描述',
`create_time` datetime NULL COMMENT '商家进驻时间',
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`orther` varchar(255) NULL COMMENT '其他信息',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uni_src_type` (`type_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='下发资源配置信息'
;


CREATE TABLE `pc_src_goods` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商铺ID',
`src_id` int(10) NOT NULL DEFAULT 0 COMMENT 'item资源ID',
`src_type` int(2) NULL DEFAULT 2 COMMENT '资源类型 1 item 2 type',
`goods_id` int(10) NOT NULL COMMENT '资源ID',
`type` int(2) NULL DEFAULT 1 COMMENT '资源类型 1、商品 2 品类 3 品牌 4买手店铺',
`thumb` varchar(128) NULL COMMENT '缩率图',
`icon` varchar(255) NULL COMMENT '小图标',
`t_status` int(2) NOT NULL DEFAULT 1 COMMENT '状态 1 新建 2 上线 3下线',
`acttype` int(2) NOT NULL DEFAULT 1 COMMENT '跳转类型 1 打开详情',
`actvalue` varchar(128) NULL COMMENT '跳转地址',
`create_time` datetime NULL COMMENT '进驻时间',
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`orther` varchar(255) NULL COMMENT '其他信息',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uni_src_goods` (`src_id`, `goods_id`, `type`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='分类项/分类信息对应的商品/banner'
;


CREATE TABLE `pc_item_item` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商铺ID',
`childid` int(10) NOT NULL DEFAULT 0 COMMENT '对应子节点 item',
`parentid` int(10) NULL DEFAULT 0 COMMENT '分类节点ID item的id',
`i_status` int(2) NULL DEFAULT 1 COMMENT '状态  1 新建 2 上线 3 下线',
`descrption` text NULL COMMENT '描述',
`create_time` datetime NULL COMMENT '商家进驻时间',
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`orther` varchar(255) NULL COMMENT '其他信息',
PRIMARY KEY (`id`) ,
INDEX `uniq_item_item` (`childid`, `parentid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='下发资源配置信息之间从属关系表'
;


CREATE TABLE `goods_details` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
`goods_id` int(10) NOT NULL COMMENT '商品ID',
`g_status` int(2) NOT NULL DEFAULT 1 COMMENT '状态 1 新建 2 审核 3 上线 4 下线',
`icon` varchar(255) NULL COMMENT '商品年份 如:2015',
`infourl` varchar(255) NULL COMMENT '详情图文',
`desc` text NOT NULL COMMENT '详情描述',
`other` varchar(255) NULL COMMENT '其他信息',
`create_time` datetime NOT NULL,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uni_goods_details` (`goods_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='商品详情信息'
;


CREATE TABLE `goods_size_price` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
`goods_id` int(10) NOT NULL COMMENT '商品ID',
`g_status` int(2) NOT NULL DEFAULT 1 COMMENT '状态 1 新建 2 审核 3 上线 4 下线',
`icon` varchar(255) NULL COMMENT '商品年份 如:2015',
`infourl` varchar(255) NULL COMMENT '详情图片',
`desc` text NOT NULL COMMENT '详情描述',
`other` varchar(255) NULL COMMENT '其他信息',
`create_time` datetime NOT NULL,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uni_goods_details` (`goods_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='商品属性对应价格信息'
;


