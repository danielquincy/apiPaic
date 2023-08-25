package com.api.repo;

import com.api.modelo.CdrLogs;
import org.springframework.data.repository.CrudRepository;

public interface CdrLogsCrud extends CrudRepository<CdrLogs, Integer> {
}
