package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DatabaseDrive.Conn;
import entity.Country;

public class Countrydao {
	List<Country> countrys=new ArrayList<Country>();
	Map<String,String> countryss = new HashMap<String,String>();
	final public static String[] coun = { "中国",  "阿尔巴尼亚",  "阿尔及利亚",  "阿富汗",  "阿根廷",  "阿拉伯联合酋长国",  "阿鲁巴",  "阿曼",  "阿塞拜疆",  "阿森松岛",  "埃及",  "埃塞俄比亚",  "爱尔兰",  "爱沙尼亚",  "安道尔",  "安哥拉",  "安圭拉",  "安提瓜岛和巴布达",  "奥地利",  "奥兰群岛",  "澳大利亚",  "巴巴多斯岛",  "巴布亚新几内亚",  "巴哈马",  "巴基斯坦",  "巴拉圭",  "巴勒斯坦",  "巴林",  "巴拿马",  "巴西",  "白俄罗斯",  "百慕大",  "保加利亚",  "北马里亚纳群岛",  "贝宁",  "比利时",  "冰岛",  "波多黎各",  "波兰",  "波斯尼亚和黑塞哥维那",  "玻利维亚",  "伯利兹",  "博茨瓦纳",  "不丹",  "布基纳法索",  "布隆迪",  "布韦岛",  "朝鲜",  "丹麦",  "德国",  "东帝汶",  "多哥",  "多米尼加",  "多米尼加共和国",  "俄罗斯",  "厄瓜多尔",  "厄立特里亚",  "法国",  "法罗群岛",  "法属波利尼西亚",  "法属圭亚那",  "法属南部领地",  "梵蒂冈",  "菲律宾",  "斐济",  "芬兰",  "佛得角",  "弗兰克群岛",  "冈比亚",  "刚果",  "刚果民主共和国",  "哥伦比亚",  "哥斯达黎加",  "格恩西岛",  "格林纳达",  "格陵兰",  "古巴",  "瓜德罗普",  "关岛",  "圭亚那",  "哈萨克斯坦",  "海地",  "韩国",  "荷兰",  "荷属安地列斯",  "赫德和麦克唐纳群岛",  "洪都拉斯",  "基里巴斯",  "吉布提",  "吉尔吉斯斯坦",  "几内亚",  "几内亚比绍",  "加拿大",  "加纳",  "加蓬",  "柬埔寨",  "捷克共和国",  "津巴布韦",  "喀麦隆",  "卡塔尔",  "开曼群岛",  "科科斯群岛",  "科摩罗",  "科特迪瓦",  "科威特",  "克罗地亚",  "肯尼亚",  "库克群岛",  "拉脱维亚",  "莱索托",  "老挝",  "黎巴嫩",  "立陶宛",  "利比里亚",  "利比亚",  "列支敦士登",  "留尼旺岛",  "卢森堡",  "卢旺达",  "罗马尼亚",  "马达加斯加",  "马尔代夫",  "马耳他",  "马拉维",  "马来西亚",  "马里",  "马其顿",  "马绍尔群岛",  "马提尼克",  "马约特岛",  "曼岛",  "毛里求斯",  "毛里塔尼亚",  "美国",  "美属萨摩亚",  "美属外岛",  "蒙古",  "蒙特塞拉特",  "孟加拉",  "秘鲁",  "密克罗尼西亚",  "缅甸",  "摩尔多瓦",  "摩洛哥",  "摩纳哥",  "莫桑比克",  "墨西哥",  "纳米比亚",  "南非",  "南极洲",  "南乔治亚和南桑德威奇群岛",  "瑙鲁",  "尼泊尔",  "尼加拉瓜",  "尼日尔",  "尼日利亚",  "纽埃",  "挪威",  "诺福克",  "帕劳群岛",  "皮特凯恩",  "葡萄牙",  "乔治亚",  "日本",  "瑞典",  "瑞士",  "萨尔瓦多",  "萨摩亚",  "塞尔维亚,黑山",  "塞拉利昂",  "塞内加尔",  "塞浦路斯",  "塞舌尔",  "沙特阿拉伯",  "圣诞岛",  "圣多美和普林西比",  "圣赫勒拿",  "圣基茨和尼维斯",  "圣卢西亚",  "圣马力诺",  "圣皮埃尔和米克隆群岛",  "圣文森特和格林纳丁斯",  "斯里兰卡",  "斯洛伐克",  "斯洛文尼亚",  "斯瓦尔巴和扬马廷",  "斯威士兰",  "苏丹",  "苏里南",  "所罗门群岛",  "索马里",  "塔吉克斯坦",  "泰国",  "坦桑尼亚",  "汤加",  "特克斯和凯克特斯群岛",  "特里斯坦达昆哈",  "特立尼达和多巴哥",  "突尼斯",  "图瓦卢",  "土耳其",  "土库曼斯坦",  "托克劳",  "瓦利斯和福图纳",  "瓦努阿图",  "危地马拉",  "维尔京群岛，美属",  "维尔京群岛，英属",  "委内瑞拉",  "文莱",  "乌干达",  "乌克兰",  "乌拉圭",  "乌兹别克斯坦",  "西班牙",  "希腊",  "新加坡",  "新喀里多尼亚",  "新西兰",  "匈牙利",  "叙利亚",  "牙买加",  "亚美尼亚",  "也门",  "伊拉克",  "伊朗",  "以色列",  "意大利",  "印度",  "印度尼西亚",  "英国",  "英属印度洋领地",  "约旦",  "越南",  "赞比亚",  "泽西岛",  "乍得",  "直布罗陀",  "智利",  "中非共和国"};
	
	public HashMap<String,String> SelectAllCountry() throws Exception{
		HashMap<String,String> hm = new HashMap<String,String>();
		Connection conn = Conn.getConnection();
		String sql="" +
				" select * from countries ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			hm.put(rs.getString("country_id"), rs.getString("country_name"));
		}
		return hm;
	}
	public HashMap<String,String> SelectAllCountryreturn() throws Exception{
		HashMap<String,String> hm = new HashMap<String,String>();
		Connection conn = Conn.getConnection();
		String sql="" +
				" select * from countries ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			hm.put(rs.getString("country_name"), rs.getString("country_id"));
		}
		return hm;
	}




}
