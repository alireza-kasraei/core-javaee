package net.devk.commons.data;

import java.io.Serializable;
import java.util.List;

/**
 * default implementation of {@link Page}
 *
 * @param <T> Model type
 */
public class PageImpl<T> implements Page<T>, Serializable {

    private static final long serialVersionUID = 867755909294344406L;

    /**
     * actual content of the page
     */
    private final List<T> content;
    /**
     * total elements
     */
    private final long total;
    /**
     * number of the current page , starts with zero
     */
    private final int pageNumber;
    /**
     * size of the current page
     */
    private final int pageSize;

    public PageImpl(List<T> content, long total, int pageNumber, int pageSize) {
        this.content = content;
        this.total = total;
        this.pageNumber = pageNumber;
        this.pageSize = (pageSize <= 0) ? DEFAULT_PAGE_SIZE : pageSize;
    }

    @Override
    public int getNumber() {
        return pageNumber;
    }

    @Override
    public int getSize() {
        return pageSize;
    }

    @Override
    public int getTotalPages() {
        // return Double.valueOf(Math.ceil(total / pageSize)+1).intValue();
        return (int) (total / pageSize) + ((total % pageSize == 0) ? 0 : 1);
    }

    @Override
    public int getNumberOfElements() {
        return content.size();
    }

    @Override
    public long getTotalElements() {
        return total;
    }

    @Override
    public boolean hasPreviousPage() {
        return pageNumber > 0;
    }

    @Override
    public boolean isFirstPage() {
        return pageNumber == 0;
    }

    @Override
    public boolean hasNextPage() {
        return pageNumber < (getTotalPages() - 1);
    }

    @Override
    public boolean isLastPage() {
        return pageNumber == (getTotalPages() - 1);
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public boolean hasContent() {
        return !content.isEmpty();
    }

}