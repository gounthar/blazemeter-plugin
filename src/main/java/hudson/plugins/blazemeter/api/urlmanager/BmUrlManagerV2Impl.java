package hudson.plugins.blazemeter.api.urlmanager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by dzmitrykashlach on 10/11/14.
 */
public class BmUrlManagerV2Impl implements BmUrlManager {

    private String SERVER_URL = "https://a.blazemeter.com/";
    private static String CLIENT_IDENTIFICATION = "_clientId=CI_JENKINS&_clientVersion=1.1.0&​";

    static{
        try{
            CLIENT_IDENTIFICATION= URLEncoder.encode(CLIENT_IDENTIFICATION, "UTF-8");
            CLIENT_IDENTIFICATION=CLIENT_IDENTIFICATION.substring(0,47);
            CLIENT_IDENTIFICATION= URLDecoder.decode(CLIENT_IDENTIFICATION, "UTF-8");

        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    BmUrlManagerV2Impl(String blazeMeterUrl) {
        SERVER_URL = blazeMeterUrl;
    }

    public String getServerUrl() {
        return SERVER_URL;
    }

    public String testStatus(String appKey, String userKey, String testId) {
        try {
            appKey = URLEncoder.encode(appKey, "UTF-8");
            userKey = URLEncoder.encode(userKey, "UTF-8");
            testId = URLEncoder.encode(testId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("https://a.blazemeter.com/api/rest/blazemeter/testGetStatus.json/?app_key=%s&user_key=%s&test_id=%s&",
                appKey, userKey, testId)+CLIENT_IDENTIFICATION;
    }

    public String getTests(String appKey, String userKey) {
        try {
            appKey = URLEncoder.encode(appKey, "UTF-8");
            userKey = URLEncoder.encode(userKey, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("https://a.blazemeter.com/api/rest/blazemeter/getTests.json/?app_key=%s&user_key=%s&test_id=all", appKey, userKey);

    }

    public String scriptUpload(String appKey, String userKey, String testId, String fileName) {
        try {
            appKey = URLEncoder.encode(appKey, "UTF-8");
            userKey = URLEncoder.encode(userKey, "UTF-8");
            testId = URLEncoder.encode(testId, "UTF-8");
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("https://a.blazemeter.com/api/rest/blazemeter/testScriptUpload.json/?app_key=%s&user_key=%s&test_id=%s&file_name=%s&",
                appKey, userKey, testId, fileName)+CLIENT_IDENTIFICATION;
    }

    public String fileUpload(String appKey, String userKey, String testId, String fileName) {
        try {
            appKey = URLEncoder.encode(appKey, "UTF-8");
            userKey = URLEncoder.encode(userKey, "UTF-8");
            testId = URLEncoder.encode(testId, "UTF-8");
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("https://a.blazemeter.com/api/rest/blazemeter/testArtifactUpload.json/?app_key=%s&user_key=%s&test_id=%s&file_name=%s&",
                appKey, userKey, testId, fileName)+CLIENT_IDENTIFICATION;
    }

    public String testStart(String appKey, String userKey, String testId) {
        try {
            appKey = URLEncoder.encode(appKey, "UTF-8");
            userKey = URLEncoder.encode(userKey, "UTF-8");
            testId = URLEncoder.encode(testId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("https://a.blazemeter.com/api/rest/blazemeter/testStart.json/?app_key=%s&user_key=%s&test_id=%s&",
                appKey, userKey, testId)+CLIENT_IDENTIFICATION;
    }

    public String testStop(String appKey, String userKey, String testId) {
        try {
            appKey = URLEncoder.encode(appKey, "UTF-8");
            userKey = URLEncoder.encode(userKey, "UTF-8");
            testId = URLEncoder.encode(testId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("https://a.blazemeter.com/api/rest/blazemeter/testStop.json/?app_key=%s&user_key=%s&test_id=%s&",
                appKey, userKey, testId)+CLIENT_IDENTIFICATION;
    }


    public String testReport(String appKey, String userKey, String reportId) {
        try {
            appKey = URLEncoder.encode(appKey, "UTF-8");
            userKey = URLEncoder.encode(userKey, "UTF-8");
            reportId = URLEncoder.encode(reportId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("https://a.blazemeter.com/api/rest/blazemeter/testGetReport.json/?app_key=%s&user_key=%s&report_id=%s&get_aggregate=true&",
                appKey, userKey, reportId)+CLIENT_IDENTIFICATION;
    }

    @Override
    public String getUser(String appKey, String userKey) {
        try {
            appKey = URLEncoder.encode(appKey, "UTF-8");
            userKey = URLEncoder.encode(userKey, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("%s/api/rest/blazemeter/getUserInfo/?app_key=%s&user_key=%s", SERVER_URL, appKey, userKey);
    }
}

