package org.openstack4j.openstack.compute.internal;

import java.util.List;

import org.openstack4j.api.Apis;
import org.openstack4j.api.compute.ComputeService;
import org.openstack4j.api.compute.FlavorService;
import org.openstack4j.api.compute.ImageService;
import org.openstack4j.api.compute.QuotaSetService;
import org.openstack4j.api.compute.ServerService;
import org.openstack4j.model.common.Extension;
import org.openstack4j.openstack.common.ExtensionValue.NovaExtensions;

/**
 * Compute (Nova) Operations API implementation
 * 
 * @author Jeremy Unruh
 */
public class ComputeServiceImpl extends BaseComputeServices implements ComputeService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FlavorService flavors() {
		return Apis.get(FlavorService.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImageService images() {
		return Apis.get(ImageService.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ServerService servers() {
		return Apis.get(ServerService.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QuotaSetService quotaSets() {
		return Apis.get(QuotaSetService.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<? extends Extension> listExtensions() {
		return get(NovaExtensions.class, uri("/extensions")).execute().getList();
	}

}