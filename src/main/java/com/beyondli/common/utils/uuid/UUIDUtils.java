package com.beyondli.common.utils.uuid;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author beyondLi
 * @desc uuid生成.
 */
public final class UUIDUtils {

    private UUIDUtils() { }

    /**
     * 获取UUID，不含有-
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 批量获取UUID
     * @param size
     * @return
     */
    public static ArrayList<String> getUUIDList(int size) {
        return Stream.iterate(1, item -> item + 1)
                .limit(size)
                .map(item -> getUUID())
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
