package org.springframework.samples.petclinic.bills;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface BillRepository extends Repository {

	@Transactional(readOnly = true)
	@Cacheable("bills")
	Page<Bill> findAll(Pageable pageable) throws DataAccessException;

	@Transactional(readOnly = false)
	@org.springframework.cache.annotation.Cacheable("Bills")
	void save(Bill bill);
}
