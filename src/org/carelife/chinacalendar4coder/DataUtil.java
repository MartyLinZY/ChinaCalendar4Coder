package org.carelife.chinacalendar4coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;

public class DataUtil {
	public String[] directions = { "����", "������", "����", "���Ϸ�", "�Ϸ�", "���Ϸ�", "����",
			"������" };
	public String[] tools = { "Eclipseд����", "MSOfficeд�ĵ�", "���±�д����",
			"Windows8", "Linux", "MacOS", "IE", "Android�豸", "iOS�豸" };
	public String[] varNames = { "jieguo", "huodong", "pay", "expire",
			"zhangdan", "every", "free", "i1", "a", "virtual", "ad", "spider",
			"mima", "pass", "ui" };
	public String[] drinks = { "ˮ", "��", "���", "�̲�", "����", "�̲�", "����", "ţ��",
			"����", "��֭", "��ζ��ˮ", "�մ�ˮ", "�˶�����", "����", "��" };

	public List<HashMap<String, String>> activities = new ArrayList<HashMap<String, String>>();

	public DataUtil(Context context) {
		readStream(context.getResources().openRawResource(R.raw.activities));
	}

	private void readStream(InputStream is) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				HashMap<String, String> activity = new HashMap<String, String>();
				String[] content = line.split("#");
				activity.put("name", content[0]);
				activity.put("good", content[1]);
				activity.put("bad", content[2]);
				activities.add(activity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// String[] specials = {
	// {date:20130207, type:'good', name:'��ע���ǳ�', description:''},
	// {date:20130208, type:'good', name:'��ע���漆', description:'ǰAKB48Ŷ'}
	// };

}
