package com.baizhi;

import com.baizhi.entity.EmsAdmin;
import com.baizhi.service.EmsAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmssApplicationTests {
	@Autowired
	private EmsAdminService emsAdminService;

	@Test
	public void contextLoads() {
		Map<String, Object> all = emsAdminService.getAll(1, 10);
		List<EmsAdmin> rows = (List<EmsAdmin>) all.get("rows");
		rows.forEach(emsAdmin -> System.out.println(emsAdmin));
	}

}
