package xyz.tcbuildmc.common.liteconfig.util;

import xyz.tcbuildmc.common.liteconfig.annotation.Comment;

import java.util.Arrays;

public final class CommentUtils {
    public static void appendComment(StringBuilder sb, Comment comment) {
        Arrays.stream(comment.value())
                .filter(s -> !StringUtils.isEmpty(s))
                .forEach(s -> sb.append("// ")
                        .append(s)
                        .append(FileUtils.getLineSeparator()));
        sb.deleteCharAt(sb.length() - 1);
    }
}
