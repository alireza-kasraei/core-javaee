package net.devk.commons.data;

/**
 * represent paging information
 */
public interface Pageable {

	/**
	 * @return number of a page , starts with zero
	 */
	public int getPageNumber();

	/**
	 * @return size of page
	 */
	public int getPageSize();

	/**
	 * @return the index or number of the first record of the page
	 */
	public int getFirstRecordNumber();

}
