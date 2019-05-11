package net.devk.commons.data;

/**
 * default implementation of {@link Pageable}
 */
public class PageRequest implements Pageable {

	private final int pageNumber;
	private final int pageSize;

	public PageRequest(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public int getFirstRecordNumber() {
		return pageNumber * pageSize;
	}

}
