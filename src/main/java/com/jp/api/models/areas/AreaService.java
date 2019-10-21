package com.jp.api.models.areas;

import com.amazonaws.util.CollectionUtils;
import com.jp.api.utils.ErrorTranslator;
import com.jp.api.utils.Preconditions;
import com.jp.api.web.postoffices.AddressResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for {@link Area}.
 *
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AreaService {
	
	/**
	 * {@link AreaRepository}
	 */
	private final AreaRepository areaRepo;
	
	/**
	 * {@link ErrorTranslator}
	 */
	private final ErrorTranslator exp;
	
	
	/**
	 * Find single {@link @Area}.
	 *
	 * @param postCode post code
	 *
	 * @return Found {@link AddressResponse}
	 *
	 */
	public List<AddressResponse> findByPostCode(String postCode) throws NotFoundException {
		Preconditions.checkNotNull(postCode, exp.translate("controller.post.get.not_null", postCode));
		Preconditions.checkHalfSize(postCode, exp.translate("controller.post.get.halfsize_number", postCode));
		
		List<AddressResponse> addressList =
				areaRepo.findByPostPostCode(postCode).stream().map(AddressResponse::new).collect(Collectors.toList());
		if (CollectionUtils.isNullOrEmpty(addressList)) {
			throw new NotFoundException(exp.translate("controller.post.get.post_not_found", postCode));
		}
		return addressList;
	}
	
}
