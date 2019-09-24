package ms.me.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SubtractiveType {
    PARTIAL("부분차감가능"),
    ALL_OR_NOTHING("전체차감만가능");

    private String desc;
}
