/**
 * Copyright 2014-2021 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.webase.node.mgr.lite.contract.event;

import com.webank.webase.node.mgr.lite.base.code.ConstantCode;
import com.webank.webase.node.mgr.lite.base.entity.BasePageResponse;
import com.webank.webase.node.mgr.lite.base.entity.BaseResponse;
import com.webank.webase.node.mgr.lite.config.properties.ConstantProperties;
import com.webank.webase.node.mgr.lite.base.tools.JsonTools;
import com.webank.webase.node.mgr.lite.base.tools.pagetools.List2Page;
import com.webank.webase.node.mgr.lite.contract.event.entity.ContractEventInfo;
import com.webank.webase.node.mgr.lite.contract.event.entity.NewBlockEventInfo;
import com.webank.webase.node.mgr.lite.contract.event.entity.ReqEventLogList;
import com.webank.webase.node.mgr.lite.contract.event.entity.RspContractInfo;
import java.io.IOException;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.List;


/**
 * event register info controller
 * @author marsli
 */
@Log4j2
@RestController
@RequestMapping("event")
public class EventController {

	@Autowired
	private EventService eventService;

	/**
	 * sync get event logs list
	 */
	@PostMapping("/eventLogs/list")
	@PreAuthorize(ConstantProperties.HAS_ROLE_ADMIN_OR_DEVELOPER)
	public BasePageResponse queryEventLogList(@RequestBody @Valid ReqEventLogList param) {
		Instant startTime = Instant.now();
		log.info("start queryEventLogList startTime:{} param:{}",
			startTime.toEpochMilli(), JsonTools.toJSONString(param));
		BasePageResponse baseResponse = eventService.getEventLogList(param);
		log.info("end queryEventLogList useTime:{} result:{}",
			Duration.between(startTime, Instant.now()).toMillis(), JsonTools.toJSONString(baseResponse));
		return baseResponse;
	}

	/**
	 * query list of contract only contain groupId and contractAddress and contractName
	 */
	@GetMapping("/contractInfo/{groupId}/{type}/{contractAddress}")
	public BaseResponse findByAddress( @PathVariable Integer groupId,
		@PathVariable String type, @PathVariable String contractAddress) {
		BaseResponse response = new BaseResponse(ConstantCode.SUCCESS);
		log.info("findByAddress start. groupId:{},contractAddress:{},type:{}", groupId, contractAddress, type);
		Object abiInfo = eventService.getAbiByAddressFromBoth(groupId, type, contractAddress);
		response.setData(abiInfo);
		return response;
	}

	/**
	 * query list of (deployed)contract only contain groupId and contractAddress and contractName
	 */
	@GetMapping("/listAddress/{groupId}")
	public BaseResponse listAbi(@PathVariable Integer groupId) throws IOException {
		BaseResponse response = new BaseResponse(ConstantCode.SUCCESS);
		log.info("listAbi start. groupId:{}", groupId);
		List<RspContractInfo> resultList = eventService.listContractInfoBoth(groupId);
		response.setData(resultList);
		return response;
	}
}
