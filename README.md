# 123 SduBotR
**Tips:This is a Chinese repository.**<br>
**The javadocs and comments in the source file are all Chinese.**<br>
**If you want to help us translate this repository to your own language, you can create a new branch, called master-(your language).**<br>
<br>
*'R' means Resurrection!*<br>
<br>
[![996.icu](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu)
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)
<p><b><font color="red">注意：本程序最佳运行环境为酷Q Pro，您可以通过功能M-2测试是否可以使用所有功能。</font></b></p>
这是一个酷Q的开源QQ机器人项目。<br>
使用时请遵守相关法律法规和WTFPL开源协议。<br>
<h6>以下用“CQP”简称酷Q Pro，用“CQA”简称酷Q Air，用“CQ”简称酷Q(CQ码除外)。<br>
以下的功能编号中A指Auto,即对应功能代码在Start.java中就已自动处理,而未转到ProcessGroupMsg.java或ProcessGroupManageMsg.java中处理.<br>
以下所使用的路径均为相对于程序数据目录的路径.<br>
完整的数据目录结构见Instructions文件夹下的DataFoldersAndFiles.txt.</h6>

## 1.项目使用的库
包括下列Java库:<br>
1.JCQ CoolQ Java Developing Plugin (by:Sobte南荒)(库文件及运行时的cpk插件文件请添加JCQ官方群427984429获取)<br>
2.123 Java Helper (by:御坂12456)(库文件在123 Java Helper文件夹中)<br>
3.FastJson 1.2.66 (by:Alibaba)(库文件在lib文件夹中)

## 2.项目运行环境
1.CQA/CQP(32位)<br>
2.Java Jre 1.8<br>
4.CQ插件:[JCQ]开发工具

## 3.项目包含的功能
**!注意:该列表自Alpha 0.5.1起停止更新,请在群内向Bot发送!m查看功能菜单**<br>
**!注意:下列内容为123 SduBotR原版(Github版)功能。如果你有什么新奇的玩意想添加，可以pull，然后在这里加上你的功能名、操作方法和昵称。**<br>
**大部分指令保留了中文指令的兼容性(Alpha 0.1.7新增)，您可以在对应功能处找到中文兼容指令(不建议使用中文指令)**<br>
**参数种类: [必填参数] {选填参数}**<br>
<a href="README_master.md">机器人主人私聊功能传送门</a>
### 1.群管理核心功能
#### 1-1.禁言功能(更新版本:Alpha 0.1.4)
说明：该功能可以在群内禁言对应成员<br>
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!mt &#91;@/QQ号&#93; &#91;时长(单位:分钟)&#93;</code><br>
**中文兼容指令: "禁言" = "!mt"**<br>
如:<br>
<code>!mt @我就是个萌新啦 60 //禁言群内昵称为"我就是个萌新啦"的成员(若重名则以实际at为准,下同)1小时</code><br>
<code>!mt 123456789 43200 //禁言群内QQ号为123456789的成员30天(手机端QQ仍会显示为29天23小时59分钟)</code><br>
<code>!mt 987654321 43199 //禁言群内QQ号为987654321的成员29天23小时59分钟</code>
#### 1-2.解禁功能(更新版本:Alpha 0.1.4)
说明：该功能可以在群内解禁对应成员<br>
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!um &#91;@/QQ号&#93;</code><br>
**中文兼容指令: "解禁" = "!um"**<br>
如:<br>
<code>!um @我就是个萌新啦 60 //解除群内昵称为"我就是个萌新啦"的成员的禁言</code><br>
<code>!um 123456789 //解除群内QQ号为123456789的成员的禁言</code>
#### 1-3.踢人功能(更新版本:Alpha 0.1.4)
说明：该功能可以在群内踢出对应成员<br>
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!k &#91;@/QQ号&#93;</code><br>
**中文兼容指令: "踢" = "!k"**<br>
如:<br>
<code>!k @我就是个萌新啦 //踢出群内昵称为"我就是个萌新啦"的成员</code><br>
<code>!k 123456789 //踢出QQ号为123456789的成员</code>
#### 1-4.永踢人功能（慎用！）(更新版本:Alpha 0.1.4)
说明：该功能可以在群内永久踢出对应成员（由于永久踢出后机器人将无法再次接收到对应成员的加群请求，故请慎用本功能）<br>
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!fk &#91;@/QQ号&#93;</code><br>
**中文兼容指令: "永踢" = "!fk"**<br>
如:<br>
<code>!fk @我就是个萌新啦 //永久踢出群内昵称为"我就是个萌新啦"的成员</code><br>
<code>!fk 123456789 //永久踢出QQ号为123456789的成员</code>
#### 1-5.群黑名单功能(更新版本:Alpha 0.2.5)
说明：该功能可以在群内设置一个黑名单，如果机器人检测到黑名单成员尝试加群将会被拒绝<br>
##### 1-5-1.开启黑名单
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!blist start</code><br>
##### 1-5-2.关闭黑名单
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!blist stop</code><br>
##### 1-5-3.添加黑名单成员
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!blist add [成员1的QQ号/at] {成员n的QQ号/at...}</code><br>
##### 1-5-4.移除黑名单成员
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!blist del [成员1的QQ号/at] {成员n的QQ号/at...}</code><br>
##### 1-5-5.查看黑名单
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!blist show</code><br>
##### 1-5-6.切换黑名单成员入群拒绝提醒状态
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!blist cnp</code><br>
##### 1-5-7.切换退群加黑开启状态
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!blist eab</code><br>
### 2.群管理辅助功能
#### 2-1.违禁词提醒功能(更新版本:Alpha 0.0.1)
说明：该功能可以在管理员无法直接长时间盯群时，群内有人发违禁词，第一时间获悉并主动处理。<br>
该功能会确认有权限情况下撤回消息并禁言1小时（成功与否将在私聊提示中写出）<br>
使用方法：<br>
在数据库"\group\list.db" -> 数据表"iMG" 中添加你想要让机器人提醒的群<br>
在数据库"\group\list.db" -> 数据表"iMGBan" 中添加违禁词<br>
如:<br>
<code>&#91;CQ:face,id=13&#93; //呲牙</code><br>
<code>&#91;CQ:face,id=107&#93; //快哭了</code><br>
<code>&#91;CQ:emoji,id=128116&#93; //Emoji:爷</code>
#### 2-2.群自定义迎新提醒功能(更新版本:Alpha 0.4.2)
说明：该功能可以在新成员入群时发送自定义的迎新提示，若未自定义则迎新时发送默认提示。<br>
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!swc [迎新内容]</code><br>
其中:<br>
【@】：代替@新成员<br>
【成员序号】：代替入群成员在该群的成员序号<br>
【申请者】：代替入群人员昵称<br>
【操作者】：代替通过入群的管理员昵称<br>
【申请QQ】：代替入群人员QQ号<br>
【操作QQ】：代替通过入群的管理员QQ号<br>
##### 2-3.群自定义退群提醒功能(更新版本:Alpha 0.4.2)
说明：该功能可以在成员退群时发送自定义的退群提示，若未自定义则成员退群时发送默认提示。<br>
使用方法：<br>
群内任意管理组成员在群内发送<br>
<code>!seg [退群提醒内容]</code><br>
其中:<br>
【退群者】：代替退群人员昵称<br>
【操作者】：代替踢出成员的管理员昵称(若成员是自行退群则此条将返回null)<br>
【退群QQ】：代替退群人员QQ号<br>
【操作QQ】：代替踢出成员的管理员QQ号(若成员是自行退群则此条将返回null)<br>
#### 2-A1.群管理员变动提醒功能(更新版本:Alpha 0.1.5)
说明：该功能会在群内管理员变动时发送一条消息以提醒。<br>
若被变动的对象是机器人QQ还会提醒由此引起的部分功能的开关。

### 3.群增强功能
#### 3-1.群成员日发言榜提醒功能(更新版本:Alpha 0.1.7)
说明：该功能可在群内发送当日的群成员发言排行榜（Top10）<br>
使用方法：<br>
在群内发送<br>
<code>!rk</code><br>
**中文兼容指令: "成员活跃榜" = "!rk"**<br>
#### 3-2.签到/打卡(更新版本:Alpha 0.5.0)
说明：该功能可在群内进行本群的签到操作。<br>
使用方法：<br>
在群内发送<br>
<code>!sign</code><br>
或直接发送QQ签到/打卡卡片<br>
**中文兼容指令："签到" = "!sign"**<br>
#### 3-3.查看签到排行数据
说明：该功能可在群内发送本群和全群的今日签到排行榜。<br>
使用方法：<br>
在群内发送<br>
<code>!rksign</code><br>
**中文兼容指令："签到排行榜" = "!rksign"**<br>

### 4.实用功能
#### 4-1.Bilibili相关功能(更新版本:Alpha 0.3.1)
##### 4-1-1.Bilibili实时粉丝数据
使用方法：<br>
在群内发送<br>
<code>!bf [UID]</code><br>
##### 4-1-2.BV与AV号互转
使用方法：<br>
在群内发送<br>
<code>!bavid [视频链接]</code><br>
#### 4-2.随机选择选项(更新版本:Alpha 0.3.1)
使用方法：<br>
在群内发送<br>
<code>!slct [选项1] {选项2}...</code><br>

### 机器人主人专用功能
#### M-1.查看运行状态功能(更新版本:Alpha 0.0.5)
说明：该功能可在群内发送机器人的运行状态<br>
使用方法：<br>
机器人主人在群内发送<br>
<code>#stat</code>
#### M-2.测试机器人是否为最佳运行环境(更新版本:Alpha 0.1.0)
说明：该功能将在群内发送一个测试图片来测试程序的所有功能是否可以正常运行（是否使用酷Q Pro运行本程序）<br>
使用方法：<br>
机器人主人在群内发送<br>
<code>#testpic</code>
#### M-3.机器人黑名单(更新版本:Alpha 0.1.1)
说明：该功能可以将某些乱玩机器人的人员加入机器人黑名单当中，无法继续使用机器人，从而防止机器人被滥用<br>
使用方法：<br>
机器人主人在群内发送<br>
<code>#banadd [@/QQ号] //添加黑名单人员</code><br>
<code>#bandel [@/QQ号] //删除黑名单人员</code><br>
<b>注意：<br>
1.机器人主人无法添加自己进入黑名单<br>
2.黑名单人员若试图邀请机器人入群或添加机器人为好友均将被拒绝(Alpha 0.1.6添加)<br>
</b><br>
#### M-4:机器人群聊警告+黑名单列表(更新版本:Alpha 0.1.3)
说明：该功能可以临时或永久屏蔽某些乱玩机器人的群聊，对应群聊除主人外的所有其它人均无法继续使用机器人，从而防止机器人被滥用<br>
使用方法：<br>
<i>(参见机器人主人功能6.7.)</i><br>
#### M-5:机器人冲突屏蔽(更新版本:Alpha 0.5.0)
说明：该功能可以通过彻底屏蔽其它机器人QQ号的消息从而防止机器人相互冲突<br>
使用方法：<br>
在数据库"\group\list.db" -> 数据表"conflictWL" 中添加要屏蔽的其它机器人的QQ号<br>
<font color="red">警告：此列表中所有QQ号彻底无法使用机器人(防止冲突),请勿添加非机器人账号到本群(如需屏蔽请使用功能M-3)</font><br>
#### M-6:垃圾清理(更新版本:Alpha 0.5.1)
说明：该功能可以将\data\目录下所有不需要的垃圾文件全部清理掉防止垃圾文件占用硬盘空间过大。建议定期指定一次本指令。<br>
使用方法：<br>
机器人主人在群内发送<br>
<code>#clean</code><br>
#### M-A1.机器人自动同意主人群聊邀请(更新版本:Alpha 0.0.8)
说明:该功能将会自动同意机器人主人的群聊邀请(任何情况下)<br>
使用方法: <br>
程序运行时邀请机器人即可,机器人会自动进群;如果主人是普通成员还需要对应群管理员的审核.<br>
#### M-A2.机器人防滥用保护(更新版本:Alpha 0.2.3)
说明:该功能会通过以下方式防止机器人被滥用:<br>
1.在指令执行过程中不处理同一人发的其它指令，若检测到，则将该人计入滥用名单<br>
2.在指令执行完成后5秒中内不处理同一人发的其他指令，若检测到，则将该人计入滥用名单<br>
使用方法: <br>
正常使用情况下如果发生以上二者其一，即将对应人员加入临时滥用名单；若需解除滥用需要按提示输入验证码。<br>
#### M-A3.机器人防侮辱提醒(更新版本:Alpha 0.2.5)
说明:该功能会检测每条消息是否存在侮辱机器人的情况，若是则在对应群聊发送一个点同时通知机器人主人<br>
#### M-A4.机器人定时备份数据(5分钟一个循环)(更新版本:Alpha 0.2.5)
说明:该功能将在机器人启动后每隔5分钟自动备份一次数据，若下次遇到未正常关闭应用将可恢复数据。
#### M-A5.机器人已受邀入群提醒(更新版本:Alpha 0.2.6)
说明:该功能将在除主人外人员邀请机器人并已经入群的情况下向机器人主人发送已入群提醒。

### 其它功能
#### O-1.关于(更新版本:Alpha 0.1.0)
说明：该功能可在群内发送"关于 123SduBotR"的相关信息<br>
使用方法:<br>
在群内发送<br>
<code>!about</code><br>
**中文兼容指令: "关于" = "!about"**<br>
#### O-2.功能菜单(更新版本:Alpha 0.1.4)
说明：该功能将向指令发送者私聊发送123 SduBotR的完整功能菜单（不含机器人主人专用功能）<br>
使用方法:<br>
在群内发送<br>
<code>!m</code><br>
**中文兼容指令: "菜单" 或 "功能" 或 "帮助" = "!m"**<br>
#### O-3.解除防滥用(更新版本:Alpha 0.2.3)
本功能详细介绍请见功能M-A2<br>
使用方法:<br>
在群内发送<br>
<code>!uab</code><br>
按提示输入正确的验证码后解除防滥用。<br>

### 特殊功能
#### S-A1.退群提醒(更新版本:Alpha 0.2.7)
说明：该功能会在成员退群时向群内发送提醒<br>
（注意:该功能与功能1-5-7属于同一功能的不同部分）<br>

#### S-A2.滑稽(斜眼笑)彩蛋(更新版本:Alpha 0.5.0)
说明：该功能会在群内以一定的概率随机发送滑稽<br>

###### 本项目由御坂12456(Misaka12456)开发并发布至Github.
###### 感谢名单:
###### Sugar 404(1668385924)
###### Gn23(1347676235)
###### NIGHTMARE XS(2019824480)
###### Saikyo_DOROC(543329382)
###### TYBR★2394425147(2394425147)
###### 傻葱Solocon(3024014059)
###### 寒意(2994273926)
###### 孤灯照镜上(2926704797)
