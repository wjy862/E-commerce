-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 04 juil. 2020 à 13:51
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `4px`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `adid` int(11) NOT NULL COMMENT '管理员id\r\n',
  `adname` varchar(20) NOT NULL COMMENT '管理员账号\r\n',
  `pwd` varchar(20) NOT NULL COMMENT '密码\r\n',
  `role` varchar(20) NOT NULL COMMENT '管理员类型\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`adid`, `adname`, `pwd`, `role`) VALUES
(1, 'admin', 'admin', 'general');

-- --------------------------------------------------------

--
-- Structure de la table `adress`
--

CREATE TABLE `adress` (
  `aid` int(11) NOT NULL,
  `aname` varchar(20) NOT NULL COMMENT '收件人\r\n',
  `atelephone` int(20) NOT NULL COMMENT '电话\r\n',
  `aadress` varchar(50) NOT NULL COMMENT '地址\r\n',
  `acp` int(11) NOT NULL COMMENT '邮编\r\n',
  `adepartement` varchar(20) NOT NULL COMMENT '省区\r\n',
  `uid` int(11) NOT NULL COMMENT '用户id\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adress`
--

INSERT INTO `adress` (`aid`, `aname`, `atelephone`, `aadress`, `acp`, `adepartement`, `uid`) VALUES
(1, 'junyi', 37526489, '9 rue escoussiere', 31000, 'Toulouse', 1),
(2, 'xinxin', 375856489, '10 rue escoussiere', 31000, 'Toulouse', 1),
(3, 'kimi', 375256489, '11 rue escoussiere', 31000, 'Toulouse', 1),
(4, 'bianshiye', 35226489, '12 rue escoussiere', 31000, 'Toulouse', 1),
(6, 'cx f', 1000, 'cdscscs', 3, 'dvdfdsf', 2);

-- --------------------------------------------------------

--
-- Structure de la table `bon`
--

CREATE TABLE `bon` (
  `bid` int(11) NOT NULL,
  `bamout` int(11) NOT NULL COMMENT '金额\r\n',
  `conditionutilisation` varchar(20) NOT NULL COMMENT '使用条件\r\n',
  `conditionroute` varchar(20) NOT NULL COMMENT '使用路线\r\n',
  `btype` varchar(20) NOT NULL COMMENT '代金券可顶替类型\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `command`
--

CREATE TABLE `command` (
  `numcn` int(20) DEFAULT NULL COMMENT '运单号\r\n',
  `cid` int(11) NOT NULL,
  `time` varchar(30) DEFAULT NULL COMMENT '预报时间\r\n',
  `weighttotal` decimal(7,2) DEFAULT NULL COMMENT '重量\r\n',
  `weightpervolume` decimal(7,2) DEFAULT NULL COMMENT '体积重\r\n',
  `volume` decimal(7,2) DEFAULT NULL COMMENT '体积\r\n',
  `weightreal` decimal(7,2) DEFAULT NULL COMMENT '计费重量\r\n',
  `amountlivraison` decimal(7,2) DEFAULT NULL COMMENT '运费\r\n',
  `declaredprice` decimal(7,2) DEFAULT NULL COMMENT '申报价格\r\n',
  `description` varchar(500) DEFAULT NULL COMMENT '费用明细\r\n',
  `statuspayment` varchar(11) DEFAULT NULL COMMENT '支付状态\r\n',
  `depotname` varchar(20) DEFAULT NULL COMMENT '转运仓名\r\n',
  `logisticsnum` int(11) DEFAULT NULL COMMENT '中国物流单号\r\n',
  `typetransport` varchar(20) DEFAULT NULL COMMENT '转运方式\r\n物流服务\r\n',
  `service` varchar(20) DEFAULT NULL COMMENT '物流服务\r\n\r\n',
  `insurance` varchar(20) DEFAULT NULL COMMENT '增值服务（保险）',
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `command`
--

INSERT INTO `command` (`numcn`, `cid`, `time`, `weighttotal`, `weightpervolume`, `volume`, `weightreal`, `amountlivraison`, `declaredprice`, `description`, `statuspayment`, `depotname`, `logisticsnum`, `typetransport`, `service`, `insurance`, `uid`) VALUES
(3, 1, 'time', '1.50', '1.60', '1.10', '1.20', '1.30', '1.40', 'cdscscs', 'dvdfdsf', '25CSDC', 10225, 'cdscscs', 'dvdfdsf', '25CSDC', 1),
(3, 2, 'time', '1.50', '1.60', '1.10', '1.20', '1.30', '1.40', 'cdscscs', 'dvdfdsf', '25CSDC', 10225, 'cdscscs', 'dvdfdsf', '25CSDC', 1),
(3, 3, NULL, '1.50', '1.60', '1.10', '1.20', '1.30', '1.40', 'kjkjcdscscs', 'dvdfdsf', '25CSjkDC', 10225, 'cdsjkcscs', 'dvftdfdsf', NULL, 1),
(3, 4, '2020-07-04 19:37:59 下午', '2.00', '1.60', '1.10', '1.20', '1.30', '1.40', 'cdscscs', 'dvdfdsf', '25CSDC', 10225, 'cdscscs', 'dvdfdsf', '25CSDC', 3);

-- --------------------------------------------------------

--
-- Structure de la table `contain`
--

CREATE TABLE `contain` (
  `pid` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL COMMENT '数量\r\n',
  `prix` decimal(10,2) NOT NULL COMMENT '申报价格\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `objectparcel`
--

CREATE TABLE `objectparcel` (
  `oid` int(11) NOT NULL,
  `odescription` varchar(20) NOT NULL COMMENT '物品名\r\n',
  `tpid` int(11) NOT NULL COMMENT '细分类型id\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `parcel`
--

CREATE TABLE `parcel` (
  `pid` int(11) NOT NULL,
  `pname` varchar(50) NOT NULL COMMENT '物品名称\r\n',
  `cid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `possess`
--

CREATE TABLE `possess` (
  `bid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `blimitedate` varchar(50) NOT NULL COMMENT '时限\r\n',
  `bquantite` int(11) NOT NULL COMMENT '数量\r\n',
  `bstatus` int(11) NOT NULL COMMENT '优惠卷状态，是否失效\r\n',
  `bdatefin` varchar(30) NOT NULL COMMENT '失效日期\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `typeparcel`
--

CREATE TABLE `typeparcel` (
  `tid` int(11) NOT NULL,
  `tdescription` varchar(20) NOT NULL COMMENT '类型内容\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `typepreciseparcel`
--

CREATE TABLE `typepreciseparcel` (
  `tpid` int(11) NOT NULL,
  `tpdescription` varchar(20) NOT NULL COMMENT '细分类型名\r\n',
  `tid` int(11) NOT NULL COMMENT '类型id\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `uname` varchar(20) DEFAULT NULL COMMENT '用户名\r\n',
  `telephone` int(10) NOT NULL COMMENT '用户电话\r\n',
  `photo` varchar(100) DEFAULT NULL COMMENT '头像\r\n',
  `mail` varchar(50) DEFAULT NULL COMMENT '邮箱\r\n',
  `gender` varchar(11) DEFAULT NULL COMMENT '性别\r\n',
  `birthday` varchar(11) DEFAULT NULL COMMENT '生日\r\n',
  `currentbalance` int(11) DEFAULT NULL COMMENT '当前余额\r\n',
  `rebate` int(11) DEFAULT NULL COMMENT '当前返利收益\r\n',
  `pwd` int(20) NOT NULL COMMENT '密码\r\n',
  `status` varchar(10) NOT NULL DEFAULT '已启用'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`uid`, `uname`, `telephone`, `photo`, `mail`, `gender`, `birthday`, `currentbalance`, `rebate`, `pwd`, `status`) VALUES
(1, 'wu', 650385625, '1.jsp', 'vfdv@gmao.com', 'homme', '01-09-2020', 300, 20, 123, '已停用'),
(2, 'zs', 650385625, NULL, 'leowjy123456@gmail.com', 'homme', '01-09-2020', 300, 20, 123, '已停用'),
(3, 'wjy', 159364, NULL, 'fsfsdfvdx', 'homme', '01-09-2019', 500, 124, 123, '已停用'),
(4, '张三', 650385625, 'iphone-免费墙纸图像电话-梦想精致的-电池壁纸免费下载-86.jpg', 'leowjy123456@gmail.com', 'homme', '01-09-2020', 300, 20, 123, '已停用'),
(6, 'wjy', 159364, 'WeChat Image_20200605170533.png', 'dfgdfvdfvdfvdf', 'homme', '01-09-2019', 500, 124, 123, '已停用'),
(8, 'zs', 154567891, 'iphone-免费墙纸图像电话-梦想精致的-电池壁纸免费下载-86.jpg', 'fsfsdfvdx', 'homme', '01-09-2019', 500, 124, 123, '已停用'),
(9, 'lisi56', 159364568, 'WeChat Image_20200605170533.png', 'pfsfsdfvdx', 'homme', '01-09-2019', 500, 158, 123456, '已启用'),
(10, 'dimitri', 1545678918, 'WeChat Image_20200605170533.png', 'ki@gmail.com', 'homme', '01-09-2019', 500, 3, 123456, '已启用');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adid`);

--
-- Index pour la table `adress`
--
ALTER TABLE `adress`
  ADD PRIMARY KEY (`aid`),
  ADD KEY `adress_user_fk` (`uid`);

--
-- Index pour la table `bon`
--
ALTER TABLE `bon`
  ADD PRIMARY KEY (`bid`);

--
-- Index pour la table `command`
--
ALTER TABLE `command`
  ADD PRIMARY KEY (`cid`),
  ADD KEY `command_user_fk` (`uid`);

--
-- Index pour la table `contain`
--
ALTER TABLE `contain`
  ADD PRIMARY KEY (`pid`,`oid`),
  ADD KEY `contain_objectparcel_fk` (`oid`);

--
-- Index pour la table `objectparcel`
--
ALTER TABLE `objectparcel`
  ADD PRIMARY KEY (`oid`),
  ADD KEY `objectparcel_typepreciseparcel_fk` (`tpid`);

--
-- Index pour la table `parcel`
--
ALTER TABLE `parcel`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `parcel_command_fk` (`cid`);

--
-- Index pour la table `possess`
--
ALTER TABLE `possess`
  ADD KEY `pocess_user_fk` (`uid`),
  ADD KEY `possess_bon_fk` (`bid`);

--
-- Index pour la table `typeparcel`
--
ALTER TABLE `typeparcel`
  ADD PRIMARY KEY (`tid`);

--
-- Index pour la table `typepreciseparcel`
--
ALTER TABLE `typepreciseparcel`
  ADD PRIMARY KEY (`tpid`),
  ADD KEY `typepreciseparcel_typeparcel_fk` (`tid`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `adid` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id\r\n', AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `adress`
--
ALTER TABLE `adress`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `bon`
--
ALTER TABLE `bon`
  MODIFY `bid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `command`
--
ALTER TABLE `command`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `objectparcel`
--
ALTER TABLE `objectparcel`
  MODIFY `oid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `parcel`
--
ALTER TABLE `parcel`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `typeparcel`
--
ALTER TABLE `typeparcel`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `typepreciseparcel`
--
ALTER TABLE `typepreciseparcel`
  MODIFY `tpid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adress`
--
ALTER TABLE `adress`
  ADD CONSTRAINT `adress_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `command`
--
ALTER TABLE `command`
  ADD CONSTRAINT `command_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `contain`
--
ALTER TABLE `contain`
  ADD CONSTRAINT `contain_objectparcel_fk` FOREIGN KEY (`oid`) REFERENCES `objectparcel` (`oid`) ON UPDATE CASCADE,
  ADD CONSTRAINT `contain_parcel_fk` FOREIGN KEY (`pid`) REFERENCES `parcel` (`pid`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `objectparcel`
--
ALTER TABLE `objectparcel`
  ADD CONSTRAINT `objectparcel_typepreciseparcel_fk` FOREIGN KEY (`tpid`) REFERENCES `typepreciseparcel` (`tpid`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `parcel`
--
ALTER TABLE `parcel`
  ADD CONSTRAINT `parcel_command_fk` FOREIGN KEY (`cid`) REFERENCES `command` (`cid`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `possess`
--
ALTER TABLE `possess`
  ADD CONSTRAINT `pocess_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON UPDATE CASCADE,
  ADD CONSTRAINT `possess_bon_fk` FOREIGN KEY (`bid`) REFERENCES `bon` (`bid`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `typepreciseparcel`
--
ALTER TABLE `typepreciseparcel`
  ADD CONSTRAINT `typepreciseparcel_typeparcel_fk` FOREIGN KEY (`tid`) REFERENCES `typeparcel` (`tid`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
