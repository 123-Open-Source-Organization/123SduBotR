package cf.ots123it.open.sdubotr;

import java.lang.management.ManagementFactory;
import java.sql.Date;
import java.util.Calendar;
import java.util.TimeZone;

import org.meowy.cqp.jcq.entity.CoolQ;
import org.meowy.cqp.jcq.event.JcqAppAbstract;

import sun.misc.OSEnvironment;
/**
 * 123 SduBot 群管理代码调用类(以#开始，在群聊中使用)<br>
 * 当前暂时仅Global.java中设置的机器人主人可调用
 *  * 注意:本类中任何方法前的CQ参数请在Start类中直接用CQ即可<br>
 * <i>（若在Start类的main测试方法中调用，请使用你所new的Start实例的getCoolQ方法<br>
 * 如: <pre class="code">ProcessGroupManageMsg.main(<b>demo.getCoolQ()</b>,123456789L,123456789L,"#stat");</pre></i>）
 * @author 御坂12456
 *
 */
public abstract class ProcessGroupManageMsg extends JcqAppAbstract
{
	/**
	 * 主调用处理方法
	 * @param CQ CQ实例，详见本类注释
	 * @param groupId 消息来源群号
	 * @param qqId 消息来源成员QQ号
	 * @param msg 消息内容
	 * @see ProcessGroupManageMsg
	 * @author 御坂12456
	 */
	public static void main(CoolQ CQ,long groupId,long qqId,String msg)
	{
		//去除管理指令前的"#"标记
		msg = msg.substring(1, msg.length());
		try {
			//获得所有参数组成的数组
			String[] arguments = msg.split(" ");
			//获得第一个参数
			String arg1 = arguments[0];
			switch (arg1) //判断第一个参数
			{
			case "stat": //功能M-1:输出123 SduBotR运行状态
				Standalone_Funcs.getRunningStatus(CQ, groupId, qqId, msg);
				break;

			default:
				break;
			}
		} catch (ArrayIndexOutOfBoundsException e) { //指令格式错误
			CQ.logError("123 SduBotR", "您输入的指令格式有误,请检查后再试\n" +
							  "指令类型:群管理（机器人主人专用）指令（前缀为#）\n" +
							  "来源群号:" + Global.getGroupName(CQ, groupId) + "(" + groupId + ")\n" +
							  "您输入的指令:" + msg);
		}
		return;
	}
	/**
 * 群管理指令独立处理类
 * @author 御坂12456
 *
 */
	static class Standalone_Funcs{
		/**
	 * 功能M-1:输出123 SduBotR运行状态
	* @param  CQ CQ实例，详见本大类注释
	 * @param groupId 消息来源群号
	 * @param qqId 消息来源成员QQ号
	 * @param msg 消息内容
	 * @author 御坂12456
	 */
		public static void getRunningStatus(CoolQ CQ,long groupId,long qqId,String msg)
		{
			// 设置时区为GMT-8（解决多出8小时的Bug）
			TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
			TimeZone.setDefault(tz);
			// 获取已启动时长
			Date upTimeDate = new Date(ManagementFactory.getRuntimeMXBean().getUptime());
			// 转化为Calendar对象
			Calendar upTime = Calendar.getInstance();
			upTime.setTime(upTimeDate);
			// 对分钟和秒补零并把年、月、日、时、分、秒赋值给upTimeStr数组
			String upYear,upMonth,upDay,upHour,upMinute,upSecond;
			upYear = String.valueOf(upTime.get(Calendar.YEAR));
			upMonth = String.valueOf(upTime.get(Calendar.MONTH));
			upDay = String.valueOf(upTime.get(Calendar.DAY_OF_MONTH));
			upHour = String.valueOf(upTime.get(Calendar.HOUR_OF_DAY));
			if (upTime.get(Calendar.MINUTE) < 10) { //分补零
				upMinute = "0" + String.valueOf(upTime.get(Calendar.MINUTE));
			} else {
				upMinute = String.valueOf(upTime.get(Calendar.MINUTE));
			}
			if (upTime.get(Calendar.SECOND) < 10) { //秒补零
				upSecond = "0" + String.valueOf(upTime.get(Calendar.SECOND));
			} else {
				upSecond = String.valueOf(upTime.get(Calendar.SECOND));
			}
			String[] upTimeStr = {upYear,upMonth,upDay,upHour,upMinute,upSecond}; //赋值
			// 使用upTimeBuilder合并字符串
			StringBuilder upTimeBuilder = new StringBuilder();
			upTimeBuilder.append(upYear).append("y").append(" ").append(upMonth).append("m").append(" ").append(upDay)
			.append("d").append(" ").append(upHour).append(":").append(upMinute).append(":").append(upSecond);
			System.gc(); //通知系统进行垃圾收集
			CQ.sendGroupMsg(groupId, Global.AppName + "\n" + 
					"运行状态\n" + 
					"*本程序完全开源,项目链接:\n" + 
					"https://github.com/Misaka12456/123SduBotR\n" +
					"1.版本信息\n" +
					"程序名:" + Global.AppName + "\n" +
					"版本:" + Global.Version + "(" + Global.AppVersionNumber + ")\n" +
					"2.数据统计\n" + 
					"总共添加群聊数:" + CQ.getGroupList().size() + "\n" +
					"总共添加QQ号数:" + CQ.getFriendList().size() + "\n" +
					"3.运行环境信息\n" +
					"操作系统:" + System.getProperty("os.name") + "\n" +
					"操作系统版本:" + System.getProperty("os.version") + "\n" + 
					"Java运行时（JRE）版本:" + System.getProperty("java.runtime.version") + "\n" + 
					"数据目录:" + Global.appDirectory + "\n" +
					"程序已正常运行时间:" + upTimeBuilder.toString());
		}
	}
}
