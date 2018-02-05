package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/9/22.
 */
public class DuplicateFiles {

    public static List<List<String>> duplicateFiles(String[] directoryInfos) {
        Map<String, List<String>> map = new HashMap<>();
        for (String info : directoryInfos) {
            String[] files = info.split(" ");
            String direcoty = files[0];
            for (int i = 1; i < files.length; ++i) {
                int idx = -1;
                for (int j = 0; j < files[i].length(); ++j) {
                    if (files[i].charAt(j) == '(') {
                        idx = j;
                        break;
                    }
                }
                String fileName = direcoty + "/" + files[i].substring(0, idx);
                String content = files[i].substring(idx + 1, files[i].length() - 1);
                List<String> fileList = map.get(content);
                if (fileList == null) {
                    fileList = new ArrayList<>();
                    map.put(content, fileList);
                }
                fileList.add(fileName);
            }
        }

        List<List<String>> rs = new ArrayList<>();
        for (List<String> value : map.values()) {
            if (value.size() > 1) {
                rs.add(value);
            }
        }

        return rs;
    }
}
