/**
 * Copyright 2014-2021  the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.webank.webase.node.mgr.lock;

import com.webank.webase.node.mgr.lock.entity.TbLock;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * mapper for table tb_group.
 */
@Repository
public interface LockMapper {
    /**
     * add
     *
     * @param lockEntity
     * @return
     */
    int add(TbLock lockEntity);

    /**
     * delete
     *
     * @param lockKey
     * @return
     */
    int delete(@Param("lockKey") String lockKey);

    /**
     * update
     *
     * @param lockEntity
     * @return
     */
    int update(TbLock lockEntity);

    /**
     * get
     *
     * @param lockKey
     * @return
     */
    TbLock getLock(@Param("lockKey") String lockKey);
}
