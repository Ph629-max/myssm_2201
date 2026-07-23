import com.bigdata.dao.EmpDao;
import com.bigdata.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestEmp {
    @Autowired
    private EmpDao empDao = null;

    @Test
    public void testSelect() {
        try {
            List<Emp> emps = empDao.selectList();
            for (Emp emp : emps) {
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectId() throws Exception {
        Emp emp = empDao.selectById(empDao.selectMaxId());
        System.out.println(emp);
    }

    @Test
    public void testSelectList() throws Exception {
        List<Emp> empList = empDao.selectList();
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    public void testDelete() throws Exception {
        int id = empDao.selectMaxId();
        int i = empDao.deleteById(id);
        System.out.println("受影响的行数：" + i);
    }

    @Test
    public void testUpdate() throws Exception {
        int id = empDao.selectMaxId();
        String name = "Steven-" + (int) (Math.random() * 100);
        Emp emp = new Emp(id, name, 18000, 28, " ", 1);
        int i = empDao.updateOne(emp);
        System.out.println("受影响的行数：" + i);
    }

    @Test
    public void testInsert() throws Exception {
        //0-100的随机数：(int) (Math.random() * 100) ;
        //10000-20000的随机数：(int) (Math.random() * (20000-10000) + 10000) ;
        int salary = (int) (Math.random() * (20000 - 10000) + 10000);
        int age = (int) (Math.random() * (45 - 25) + 25);
        String name = "新员工-" + (int) (Math.random() * 100);
        Emp emp = new Emp(name, salary, age, " ", 1);
        int i = empDao.insertOne(emp);
        System.out.println("受影响的行数：" + i);
    }


    @Test
    public void testSelectByCondition() {
        try {
            List<Emp> empList = empDao.selectListByCondition(10, null, null, 25, 1);
            if (empList != null) {
                System.out.println(empList.toString());
            } else {
                System.out.println("未查询到结果！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateByCondition() {
        try {
            int count = empDao.updateByCondition(8, null, 25000.0, null, null);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
