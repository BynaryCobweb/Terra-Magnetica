/* <LICENSE>
Copyright (C) 2013-2016 Louis JEAN

This file is part of Terra Magnetica.

Terra Magnetica is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Terra Magnetica is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with Terra Magnetica. If not, see <http://www.gnu.org/licenses/>.
 </LICENSE> */

package org.terramagnetica.creator;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter {
	
	private String[] extensions;
	private String descriptif = "";
	
	public ExtensionFileFilter(String[] extensions){
		this.extensions = extensions;
	}
	
	public ExtensionFileFilter(String[] extensions, String description){
		this.extensions = extensions;
		this.descriptif = description;
	}
	
	@Override
	public boolean accept(File f) {
		if (f.isDirectory())
			return true;
		if (f != null){
			
			for (String extension : extensions){
				if (f.getName().endsWith(extension))
					return true;
			}
		}
		return false;
	}

	@Override
	public String getDescription() {
		return descriptif;
	}
}
