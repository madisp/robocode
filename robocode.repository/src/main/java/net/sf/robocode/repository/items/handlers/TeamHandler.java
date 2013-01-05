/*******************************************************************************
 * Copyright (c) 2001-2013 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 *******************************************************************************/
package net.sf.robocode.repository.items.handlers;


import net.sf.robocode.repository.IRepository;
import net.sf.robocode.repository.items.IRepositoryItem;
import net.sf.robocode.repository.items.TeamItem;
import net.sf.robocode.repository.root.IRepositoryRoot;

import java.net.URL;


/**
 * Handler for accepting and registering .team files.
 *
 * @author Pavel Savara (original)
 */
public class TeamHandler extends ItemHandler {
	public IRepositoryItem acceptItem(URL itemURL, IRepositoryRoot root, IRepository repository) {
		if (itemURL.toString().toLowerCase().endsWith(".team")) {
			return register(itemURL, root, repository);
		}
		return null;
	}

	private IRepositoryItem register(URL itemURL, IRepositoryRoot root, IRepository repository) {
		final String itemKey = itemURL.getPath();

		TeamItem item = (TeamItem) repository.getItem(itemKey);

		if (item == null) {
			item = new TeamItem(itemURL, root);
		}
		repository.addOrUpdateItem(item);
		return item;
	}
}
