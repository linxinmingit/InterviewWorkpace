package cn.yr.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerConfiguration {
	public static void main(String[] args) {
		try {
			new FreeMarkerConfiguration().genFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void genFile() throws Exception {
        // ��һ��������һ��Configuration����ֱ��newһ�����󡣹��췽���Ĳ�������freemarker���ڵİ汾�š�
        Configuration configuration = new Configuration(Configuration.getVersion());
        // �ڶ���������ģ���ļ����ڵ�·����
        configuration.setDirectoryForTemplateLoading(new File("D:/InterviewWorkpace/TestFreeMarker/templates"));
        // ������������ģ���ļ�ʹ�õ��ַ�����һ�����utf-8.
        configuration.setDefaultEncoding("utf-8");
        // ���Ĳ�������һ��ģ�壬����һ��ģ�����
        Template template = configuration.getTemplate("hello.ftl");
        // ���岽������һ��ģ��ʹ�õ����ݼ���������pojoҲ������map��һ����Map��
        Map dataModel = new HashMap<String, String>();
        //�����ݼ����������
        dataModel.put("hello", "this is my first freemarker test.");
        // ������������һ��Writer����һ�㴴��һFileWriter����ָ�����ɵ��ļ�����
//        Writer out = new FileWriter(new File("D:/temp/term197/out/hello.html"));
        Writer out = new FileWriter(new File("D:/InterviewWorkpace/TestFreeMarker/templates/hello.html"));
        // ���߲�������ģ������process��������ļ���
        template.process(dataModel, out);
        // �ڰ˲����ر�����
        out.close();
    }


}
