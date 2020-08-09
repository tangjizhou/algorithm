package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 * 简化路径
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/8/9
 */
public class SimplifyPath {

    @Test
    public void test() {
        Assert.assertEquals("/home", simplifyPath("/home/"));
        Assert.assertEquals("/", simplifyPath("/../"));
        Assert.assertEquals("/home/foo", simplifyPath("/home//foo/"));
        Assert.assertEquals("/c", simplifyPath("/a/./b/../../c/"));
    }


    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        path = path.replaceAll("/+", "/");
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.isEmpty() || ".".equals(dir)) {
                continue;
            }
            if ("..".equals(dir)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(dir);
        }
        String simplifiedPath = "";
        for (String s : stack) {
            simplifiedPath = simplifiedPath.concat("/".concat(s));
        }
        return simplifiedPath.isEmpty() ? "/" : simplifiedPath;
    }

}
