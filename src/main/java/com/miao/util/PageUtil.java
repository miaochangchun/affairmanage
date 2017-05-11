package com.miao.util;

/**
 * Created by 10048 on 2017/5/9.
 */
public class PageUtil {
    /**
     * 创建分页信息对象，只需要每页显示的数目，总的条目数，当前页三个信息
     * @param everyPage     每页显示的数目
     * @param totalCount    总的条目数
     * @param currentPage   当前页
     * @return  分页信息对象
     */
    public static Page createPage(int everyPage, int totalCount, int currentPage) {
        everyPage = getEveryPage(everyPage);
        currentPage = getCurrentPage(currentPage);
        int totalPage = getTotalPage(everyPage, totalCount);
        int benginIndex = getBeginIndex(everyPage, currentPage);
        boolean hasPrePage = getHasPrePage(currentPage);
        boolean hasNextPage = getHasNextPage(totalPage, currentPage);
        return new Page(everyPage, totalCount, totalPage, currentPage, benginIndex, hasPrePage, hasNextPage);
    }

    /**
     * 是否还有下一页
     * @param totalPage     总页数
     * @param currentPage   当前页
     * @return
     */
    private static boolean getHasNextPage(int totalPage, int currentPage) {
        return currentPage == totalPage || totalPage == 0 ? false : true;
    }

    /**
     * 是否还有上一页
     * @param currentPage   当前页
     * @return
     */
    private static boolean getHasPrePage(int currentPage) {
        return currentPage == 1 ? false : true;
    }

    /**
     * 获得起始位置
     * @param everyPage     每页显示的数目
     * @param currentPage   当前页
     * @return  起始位置
     */
    private static int getBeginIndex(int everyPage, int currentPage) {
        return (currentPage - 1) * everyPage;
    }

    /**
     * 获得总页数
     * @param everyPage     每页显示的数目
     * @param totalCount    总的记录数目
     * @return  总页数
     */
    private static int getTotalPage(int everyPage, int totalCount) {
        int totalPage = 0;
        if (totalCount != 0 && totalCount % everyPage == 0) {
            totalPage = totalCount / everyPage;
        } else {
            totalPage = totalCount / everyPage + 1;
        }
        return totalPage;
    }

    /**
     * 获得当前的页数
     * @param currentPage   当前页
     * @return  当前页
     */
    private static int getCurrentPage(int currentPage) {
        return currentPage == 0 ? 1 : currentPage;
    }

    /**
     * 获得每页显示的数目
     * @param everyPage     每页显示的数目
     * @return  每页显示的 数目
     */
    private static int getEveryPage(int everyPage) {
        return everyPage == 0 ? 10 : everyPage;
    }

}
